package anyshchenko.nikita.practice_3_20dataservice.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customize() {
        return (builder) -> {
            builder.failOnUnknownProperties(false)
                .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .visibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
                .visibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
                .defaultViewInclusion(true)
                .featuresToDisable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS)
                .serializationInclusion(JsonInclude.Include.NON_NULL);
        };
    }

}
