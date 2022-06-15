package letsgetit.auth.supertoken.config;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class BeanConfig {

    @Bean
    public Mustache.Compiler mustacheCompiler(
            Mustache.TemplateLoader templateLoader) {

        return Mustache.compiler()
                .withLoader(templateLoader);
    }
}
