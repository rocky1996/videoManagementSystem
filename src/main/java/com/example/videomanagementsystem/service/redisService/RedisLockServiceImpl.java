package com.example.videomanagementsystem.service.redisService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisLockServiceImpl {

    /**
     * 默认超时时间
     */
    private static final Long DEFAULT_TIMEOUT = 30000L;

    @Resource(name = "stringRedisTemplate")
    private RedisTemplate<String, String> stringRedisTemplate;

    /**
     * 加锁
     * @param key
     * @param expireTime
     * @return
     */
    public boolean getLock(String key, Long expireTime) {
        Long finalExpireTime = expireTime == null ? DEFAULT_TIMEOUT : expireTime;
        //value值为系统当前时间
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, String.valueOf(System.currentTimeMillis()))) {
            stringRedisTemplate.expire(key,
                    finalExpireTime,
                    TimeUnit.MILLISECONDS);
            return true;
        }

        //获取上锁时间 判断锁是否超时，超时则删除key（redis重启会造成重启时间内一些过期的key未被清理）,防止死锁
        String valueTime = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(valueTime) &&
                System.currentTimeMillis() - Long.parseLong(valueTime) > finalExpireTime) {
            //释放锁 再次抢锁
            unLock(key);
            return getLock(key, expireTime);
        }
        return false;
    }

    /**
     * 释放锁
     * @param key
     * @return
     */
    public void unLock(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        try {
            if (!StringUtils.isBlank(value)) {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("redisLockServiceImpl.unLock has error", e.getMessage());
        }
    }
}
