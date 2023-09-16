package com.example.slf4jdemo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

public class TraceInterceptor implements HandlerInterceptor {
    public static final String TRACE = "_trace";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求头中获取全局_trace
        String traceId = request.getHeader(TRACE);
        if (traceId == null) {
            traceId = UUID.randomUUID().toString().toUpperCase();
        }
        MDC.put(TRACE, traceId);
        return true;
    }
}
