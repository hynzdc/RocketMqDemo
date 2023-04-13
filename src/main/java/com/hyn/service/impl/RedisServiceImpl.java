package com.hyn.service.impl;

import com.hyn.config.RedissonConfig;
import com.hyn.entity.User;
import com.hyn.service.RedisService;
import lombok.SneakyThrows;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hyn
 * @version 1.0.0
 * @description
 * @date 2023/4/11
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedissonConfig redissonConfig;
    @SneakyThrows
    @Override
    public void save(String key, String value) {
        RedissonClient redisson = redissonConfig.redisson();
        RBucket<Object> bucket = redisson.getBucket("k2");
        RMap<String, String> k3 = redisson.getMap("k3");
        RList<String> list1 = redisson.getList("list1");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        k3.put("hyn","hynzdc");
        User user = new User();
        user.setId(1);
        user.setUsername("hyn");
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("zdc");
        RMap<String, User> map = redisson.getMap("map");
        map.put("1",user);
        map.put("2",user1);
        bucket.set("v2");
    }
}
