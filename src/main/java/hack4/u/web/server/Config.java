package hack4.u.web.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Archivos desde directorio externo
        //registry.addResourceHandler("/redirect/**").addResourceLocations("file:/var/www/static/redirect/");


        // Archivos HTML desde resources (src/main/resources)
        registry.addResourceHandler("/html/**")
                .addResourceLocations("classpath:/");
    }
}