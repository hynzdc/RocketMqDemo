package com.hyn.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 创建人：sunp
 * 创建时间：2020/4/8 0008
 * 文件名：RocketMqProducerProperties
 * 版本 修改时间 作者
 * V1.0 2020/4/8 0008 sunp
 */
@Component
@ConfigurationProperties(prefix = "rocketmq.producer")
@Data
public class RocketMqProducerProperties {
    private String isOnOff;
    private String groupName;
    private String namesrvAddr;
    private Integer maxMessageSize;
    private Integer sendMsgTimeout;
    private Integer retryTimesWhenSendFailed;
}
