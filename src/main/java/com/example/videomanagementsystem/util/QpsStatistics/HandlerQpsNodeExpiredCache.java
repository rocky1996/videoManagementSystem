package com.example.videomanagementsystem.util.QpsStatistics;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class HandlerQpsNodeExpiredCache {
    //本地map缓存,key->url,value->node值
    private Map<String, QpsNode> qpsNodeLocalCache = new ConcurrentHashMap<>();
    //可重入悲观锁
    private ReentrantLock reentrantLock = new ReentrantLock();
    //失效时间队列
    private PriorityQueue<QpsNode> queue = new PriorityQueue<>();
    //启动定时任务,每秒清理一次过期缓存
    private final static ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(10);

    public HandlerQpsNodeExpiredCache() {
        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Long currentTime = System.currentTimeMillis();
                while (true) {
                    reentrantLock.lock();
                    try {
                        QpsNode qpsNode = queue.peek();
                        if (Objects.isNull(qpsNode) || qpsNode.getExpireTime() > currentTime) {
                            return;
                        }
                        //已经超过设置的过期时间,需要清理了
                        qpsNodeLocalCache.remove(qpsNode.getKey());
                        queue.poll();
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }, 1L, 1L, TimeUnit.SECONDS);
    }


    /**
     * 获取某节点
     * @param key
     * @return
     */
    public QpsNode getQpsNode(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return qpsNodeLocalCache.get(key);
    }

    /**
     * set值
     * @param key
     * @param ttl
     */
    public void setQpsNode(String key, Long ttl) {
        QpsNode currentQpsNode = getQpsNode(key);
        if (Objects.isNull(currentQpsNode)) {
            //缓存里面不存在的节点
            AtomicLong newAtomicLong = new AtomicLong(1);
            QpsNode newQpsNode = new QpsNode(key, newAtomicLong, System.currentTimeMillis() + ttl);
            qpsNodeLocalCache.put(key, newQpsNode);
            queue.add(newQpsNode);
        }else {
            //还没有过期的节点
            AtomicLong currentAtomicLong = currentQpsNode.getCallQuantity();
            currentAtomicLong.incrementAndGet();
        }
    }
}
