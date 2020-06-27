package anyshchenko.nikita.practice_3_20dataservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private Resource jsonFilePath;
    private String apiKey;
}
