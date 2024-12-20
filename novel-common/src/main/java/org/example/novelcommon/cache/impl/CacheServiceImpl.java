package org.example.novelcommon.cache.impl;

import lombok.RequiredArgsConstructor;
import org.example.novelcommon.cache.CacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.cache.impl
 * @Project：my
 * @Date：21/11/2024 4:18 pm
 */
@RequiredArgsConstructor
@Service
public class CacheServiceImpl implements CacheService {
    private final StringRedisTemplate stringRedisTemplate;
    private final RedisTemplate<Object,Object> redisTemplate;


    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key,value,timeout);
    }

    @Override
    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setObject(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void setObject(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout);

    }
    @Override
    public void del(String key) {
        redisTemplate.delete(key);
        stringRedisTemplate.delete(key);
    }

    @Override
    public boolean contains(String key) {
        return redisTemplate.hasKey(key) || stringRedisTemplate.hasKey(key);
    }

    @Override
    public void expire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
}
