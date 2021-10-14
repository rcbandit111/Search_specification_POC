package org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"org.merchant"})
public class MerchantApplication implements WebMvcConfigurer {

    public static void main(final String[] args)
    {
        SpringApplication.run(MerchantApplication.class, args);
    }
}
