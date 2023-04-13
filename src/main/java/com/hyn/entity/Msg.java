package com.hyn.entity;

import lombok.Data;

/**
 * @author hyn
 * @version 1.0.0
 * @description 消息对象
 * @date 2023/4/11
 */
@Data
public class Msg {
    private String topic;
    private String message;
}
