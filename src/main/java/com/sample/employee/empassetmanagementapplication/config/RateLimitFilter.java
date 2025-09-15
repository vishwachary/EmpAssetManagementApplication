package com.sample.employee.empassetmanagementapplication.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import jakarta.servlet.ServletRequest;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter implements Filter {

    // Store a bucket per client IP
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if ("/addEmployee".equals(req.getRequestURI()) && "POST".equalsIgnoreCase(req.getMethod())) {
            String ip = req.getRemoteAddr();
            Bucket bucket = buckets.computeIfAbsent(ip, k ->
                    Bucket4j.builder()
                            .addLimit(Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)))) // 5 requests/min per IP
                            .build());

            if (bucket.tryConsume(1)) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).setStatus(429); // Too Many Requests
                response.getWriter().write("Rate limit exceeded. Try again later.");
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}
