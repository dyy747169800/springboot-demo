package com.dyy.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis工具类
 *
 * @author 段杨宇
 * @create 2017-12-26 14:58
 **/
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

}
