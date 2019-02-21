package com.example.provider.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello,this is hello-service"+request.getLocalPort();
    }
}
