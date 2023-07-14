package com.example.pro2.Interceptor;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    private final ThreadLocal<LocalTime> threadLocalTimeStart = new ThreadLocal<>();
    private final ThreadLocal<LocalTime> threadLocalTimeEnd = new ThreadLocal<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
    //记录开始时间
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalTime startTime = LocalTime.now();
        threadLocalTimeStart.set(startTime);
        log.info("开始时间;{}", startTime.format(formatter));
        return true;
    }

    // 记录结束时间
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        LocalTime endTime = LocalTime.now();
        threadLocalTimeEnd.set(endTime);
        log.info("结束时间:{}", endTime.format(formatter));
    }

    // 计算接口执行时间
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LocalTime startTime = threadLocalTimeStart.get();
        LocalTime endTime = threadLocalTimeEnd.get();
        log.info("接口执行时间:{} 毫秒", Duration.between(startTime, endTime).getNano() / 1000000);
    }
}
