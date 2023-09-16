package com.example.slf4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    private TestFeign testFeign;

    public TestController(TestFeign testFeign) {
        this.testFeign = testFeign;
    }

    @GetMapping("/trace")
    public Map<String, Object> trace(@RequestParam String p) {
        logger.info("trace in: {}", p);
        String trace_id = MDC.get(TraceInterceptor.TRACE);
        logger.info("trace_id={}", trace_id);
        Map<String, Object> map = testFeign.trace2(p);
        logger.info("return: {}", map);
        return map;
    }

    @GetMapping("/trace2")
    public Map<String, Object> trace2(@RequestParam String p) {
        logger.info("trace2 in: {}", p);
        Map<String, Object> res = new HashMap<>();
        res.put("input", p);
        return res;
    }

}
