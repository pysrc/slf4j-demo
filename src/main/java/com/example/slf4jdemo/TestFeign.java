package com.example.slf4jdemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "testFeign", url = "http://127.0.0.1:8080")
public interface TestFeign {
    @GetMapping("/trace2")
    Map<String, Object> trace2(@RequestParam String p);
}
