package net.andresbustamante.example.common.config;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CXFConfig {

    @Bean
    public ServletRegistrationBean dispatcherServletCxf() {
        return new ServletRegistrationBean(new CXFServlet(), "/api/*");
    }

    @Bean
    public LoggingFeature loggingFeature() {
        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);

        return loggingFeature;
    }
}
