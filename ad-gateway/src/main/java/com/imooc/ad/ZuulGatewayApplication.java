package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 网关启动类
 * @author: lvyong
 * @date: 2019-10-24
 * @time: 1:22 下午
 * @version: 1.0
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
