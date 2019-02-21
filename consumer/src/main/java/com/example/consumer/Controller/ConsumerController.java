package com.example.consumer.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorMsg")
    @RequestMapping("/hello-consumer")
    public String helloConsumer() {
        //调用hello-service服务，注意这里用的是服务名，而不是具体的ip+port
        String msg = restTemplate.getForObject("http://provider/hello", String.class);
        return msg;
    }

    public String errorMsg(){
        return "error!!!";
    }
}
