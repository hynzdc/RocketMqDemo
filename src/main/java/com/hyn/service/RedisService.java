package com.hyn.service;

import java.security.PrivateKey;

/**
 * @author hyn
 * @version 1.0.0
 * @description
 * @date 2023/4/11
 */
public interface RedisService {
    public void save(String key,String value);
}
