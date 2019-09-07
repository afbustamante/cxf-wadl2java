package net.andresbustamante.example.common.config;

import net.andresbustamante.example.controllers.UsersController;
import net.andresbustamante.example.users.controllers.impl.UsersControllerImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationInInterceptor;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationOutInterceptor;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RestServicesConfig {

    @Autowired
    private LoggingFeature loggingFeature;

    @Autowired
    private Bus bus;

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.asList(
                usersController()
        ));
        endpoint.setAddress("/rest");
        endpoint.setProvider(new JacksonJaxbJsonProvider());
        endpoint.setFeatures(Collections.singletonList(loggingFeature));
        endpoint.setInInterceptors(Collections.singletonList(new JAXRSBeanValidationInInterceptor()));
        endpoint.setOutInterceptors(Collections.singletonList(new JAXRSBeanValidationOutInterceptor()));
        Map<String, Object> properties = new HashMap<>();
        properties.put("schema-validation-enabled", true); // Activate XML validation for XSD elements
        endpoint.setProperties(properties);
        return endpoint.create();
    }

    @Bean
    public UsersController usersController() {
        return new UsersControllerImpl();
    }
}
