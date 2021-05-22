package com.wenyu7980.auth.context;

import com.google.gson.Gson;
import com.wenyu7980.authentication.context.model.ContextInfo;
import com.wenyu7980.authentication.context.model.ContextUtils;
import com.wenyu7980.common.gson.adapter.GsonUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wenyu
 */
@Configuration
@EnableWebMvc
public class ContextConfig implements WebMvcConfigurer {
    private static final String CONTEXT = "context";
    private static final Gson GSON = GsonUtil.gson();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
              throws Exception {
                ContextUtils.set(GSON.fromJson(request.getHeader(CONTEXT), ContextInfo.class));
                return true;
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
              Exception ex) throws Exception {
                ContextUtils.remove();
            }
        }).addPathPatterns("/**");
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header(CONTEXT, GSON.toJson(ContextUtils.orElse(new ContextInfo())));
            }
        };
    }

}
