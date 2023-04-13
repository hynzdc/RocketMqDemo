package com.hyn.controller;

import com.hyn.config.RedissonConfig;
import com.hyn.entity.Msg;
import com.hyn.entity.User;
import com.hyn.service.MessageService;
import com.hyn.service.RedisService;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author hyn
 * @version 1.0.0
 * @description 消息控制器
 * @date 2023/4/11
 */
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Resource
    private MessageService messageService;
    @Resource
    private RedissonConfig redissonConfig;
    @Resource
    private RedisService redisService;
    @GetMapping("/send")
    public String sendMessage(@RequestBody Msg msg){
        messageService.sendMessage(msg.getTopic(),msg.getMessage());
        return "success";
    }
    @GetMapping("/hello")
    public String sendHello(){
        return "success";
    }
    @GetMapping("/save")
    public String save(){
        redisService.save("aa","bb");
        return "success";
    }
    @GetMapping("/getList")
    public List<String> getList() throws IOException {
        RedissonClient redisson = redissonConfig.redisson();
        RList<String> list1 = redisson.getList("list1");
        return list1;
    }
    @GetMapping("/getUser")
    public Map<String,User> getUser() throws IOException {
        RedissonClient redisson = redissonConfig.redisson();
        RMap<String, User> map = redisson.getMap("map");
        return map;
    }
}
