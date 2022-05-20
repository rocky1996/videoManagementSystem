package com.example.videomanagementsystem.service.redisService;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Component
@Slf4j
public class RedisServiceImpl {

    @Resource
    private RedisTemplate redisTemplate;

    /**string***********************
     * https://blog.csdn.net/weixin_43658899/article/details/121062760
     * *****************************/
    /**
     * set
     * @param key
     * @param value
     * @param timeOut
     * @param timeUnit
     * @param isAbsent
     */
    public void set(String key, String value, Long timeOut, TimeUnit timeUnit, boolean isAbsent) {
        if (isAbsent) {
            if(judgeExpiredTime(timeOut, timeUnit)) {
                redisTemplate.opsForValue().set(key, value, timeOut, timeUnit);
            }
            redisTemplate.opsForValue().set(key, value);
        }else {
            if(judgeExpiredTime(timeOut, timeUnit)) {
                redisTemplate.opsForValue().setIfAbsent(key, value, timeOut, timeUnit);
            }
            redisTemplate.opsForValue().setIfAbsent(key, value);
        }
    }

    /**
     * 追加append
     * @param key
     * @param value
     */
    public void append(String key, String value) {
        redisTemplate.opsForValue().append(key, value);
    }

    /**
     * get
     * @param key
     * @return
     */
    public String getValue(String key) {
        return  (String) redisTemplate.opsForValue().get(key);
    }

    /**List*************************
     * https://blog.csdn.net/weixin_43658899/article/details/121040307
     * *****************************/
    /**
     * 左/右插（或批量）
     * @param key
     * @param obj
     * @param isLeft
     */
    public void push(String key, Object obj, boolean isLeft) {
        if (isLeft) {
            if (obj instanceof Collection) {
                redisTemplate.opsForList().leftPushAll(key, obj);
            }
            redisTemplate.opsForList().leftPush(key, obj);
        }else {
            if (obj instanceof Collection) {
                redisTemplate.opsForList().rightPushAll(key, obj);
            }
            redisTemplate.opsForList().rightPush(key, obj);
        }
    }

    /**
     * 删除最左(右)/指定过期时间后删除key中最左的一个值
     * @param key
     * @param timeOut
     * @param timeUnit
     */
    public void pop(String key, Long timeOut, TimeUnit timeUnit, boolean isLeft) {
        if (isLeft) {
            if(judgeExpiredTime(timeOut, timeUnit)) {
                redisTemplate.opsForList().leftPop(key, timeOut, timeUnit);
            }
            redisTemplate.opsForList().leftPop(key);
        }else {
            if(judgeExpiredTime(timeOut, timeUnit)) {
                redisTemplate.opsForList().rightPop(key, timeOut, timeUnit);
            }
            redisTemplate.opsForList().rightPop(key);
        }
    }

    /**
     * 获取List长度
     * @param key
     * @return
     */
    public Long getListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 获取指定下标间的值，默认0,-1
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List range(String key, Long start, Long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**Hash*************************
     * https://blog.csdn.net/weixin_43658899/article/details/121063660
     * *****************************/
    /**
     * 新增
     * @param key
     * @param hk
     * @param hv
     */
    public void put(String key, Object hk, Object hv, boolean isAbsent) {
        if (isAbsent) {
            redisTemplate.opsForHash().put(key, hk, hv);
        }else {
            redisTemplate.opsForHash().putIfAbsent(key, hk, hv);
        }
    }

    /**
     * 插入map
     * @param key
     * @param map
     */
    public void put(String key, Map map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * get
     * @param key
     * @param hk
     * @return
     */
    public Object getObject(String key, Object hk) {
        return redisTemplate.opsForHash().get(key, hk);
    }

    /**
     * 获取键值对
     * @param key
     * @return
     */
    public Map entries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 判断键是否存在
     * @param key
     * @param hk
     * @return
     */
    public boolean isHasKey(String key, Object hk) {
        return redisTemplate.opsForHash().hasKey(key, hk);
    }

    /**
     * 批量删除
     * @param key
     * @param values
     */
    public void delete(String key, Objects... values) {
        redisTemplate.opsForHash().delete(key, values);
    }

    /**Set*************************
     * https://blog.csdn.net/weixin_43658899/article/details/121065237
     * *****************************/
    /**
     * 向key中批量添加值
     * @param key
     * @param values
     */
    public void add(String key, Objects...values) {
        redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 获取set
     * @param key
     * @return
     */
    public Set members(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 获取set长度
     * @param key
     * @return
     */
    public Long getSetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**Zset*************************
     * https://blog.csdn.net/weixin_43658899/article/details/121067707
     * *****************************/
    /**
     * 添加元素
     * @param key
     * @param obj
     * @param score
     */
    public void zAdd(String key, Object obj, double score) {
        redisTemplate.opsForZSet().add(key, obj, score);
    }

    /**
     * 获取key对应集合中o元素的score值
     * @param key
     * @param obj
     * @return
     */
    public double getScore(String key, Object obj) {
        return redisTemplate.opsForZSet().score(key, obj);
    }

    /**
     * 获取指定下标之间的值,0,-1
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set zRange(String key, Long start, Long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 获取指定score区间的值
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set rangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 删除指定下标之间的值,0,-1
     * @param key
     * @param start
     * @param end
     * @return
     */
    public void zRemoveRange(String key, Long start, Long end) {
        redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 删除指定score区间内的值
     * @param key
     * @param min
     * @param max
     * @return
     */
    public void zRemoveScore(String key, double min, double max) {
        redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }


    /**
     * 判断是否有过期时间
     * @param timeOut
     * @param timeUnit
     * @return
     */
    public boolean judgeExpiredTime(Long timeOut, TimeUnit timeUnit) {
        if ((!Objects.isNull(timeOut)) && (!Objects.isNull(timeUnit))) {
            return true;
        }
        return false;
    }
}
