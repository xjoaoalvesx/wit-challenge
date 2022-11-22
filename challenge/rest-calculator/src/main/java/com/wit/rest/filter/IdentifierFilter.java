package com.wit.rest.filter;

import com.wit.rest.controller.RestCalcController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class IdentifierFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(IdentifierFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        MDC.put("unique.id", uuid);
        logger.info("Request Operation: {} {} {}",
                httpServletRequest.getParameter("a"),
                httpServletRequest.getRequestURI(),
                httpServletRequest.getParameter("b")
        );
        httpServletResponse.addHeader("unique-id", uuid);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        logger.info("Finished Operation: {} {} {}",
                httpServletRequest.getParameter("a"),
                httpServletRequest.getRequestURI(),
                httpServletRequest.getParameter("b")
        );
        MDC.remove("unique.id");
    }
}
