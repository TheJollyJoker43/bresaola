package it.giovannipicco.bresaola.configuration;

import it.giovannipicco.bresaola.utils.constant.EnvLabel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository repository;
    private final Environment environment;

    public String getValue(ConfigurationKey configurationKey){
        Optional<Configuration> config = repository.findById(configurationKey.name());
        if(config.isPresent()){
            return config.get().getValue();
        } else if (!environment.getProperty(configurationKey.name()).isEmpty()) {
            return environment.getProperty(configurationKey.name());
        } else {
            return configurationKey.getDefaultValue(environment.getActiveProfiles()[0]);
        }
    }


}
