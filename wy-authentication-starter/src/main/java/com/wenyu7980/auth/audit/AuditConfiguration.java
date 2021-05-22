package com.wenyu7980.auth.audit;

import com.wenyu7980.authentication.context.model.ContextUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 *
 * @author wenyu
 */
@Configuration
@ConditionalOnClass(name = "org.springframework.data.domain.AuditorAware")
@EnableJpaAuditing
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                return Optional.ofNullable(ContextUtils.userId());
            }
        };
    }
}
