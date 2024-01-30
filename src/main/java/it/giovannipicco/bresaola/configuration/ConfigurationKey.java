package it.giovannipicco.bresaola.configuration;

import it.giovannipicco.bresaola.exception.ExceptionFactory;
import it.giovannipicco.bresaola.exception.ExceptionType;
import it.giovannipicco.bresaola.utils.constant.Environment;
import it.giovannipicco.bresaola.utils.constant.EnvironmentLabel;
import it.giovannipicco.bresaola.utils.constant.Origin;
import lombok.Getter;

public class ConfigurationKey {

    public static ConfigurationKey DEFAULT_TARGET =
            new ConfigurationKey(
                    "default.target",
                    "none",
                    "none",
                    "none"
            );

    //*****************************************
    //********** CLASS DECLARATION ************
    //*****************************************

    @Getter
    private final String key;
    @Getter
    private final Origin origin;
    private final String devDefaultValue;
    private final String uatDefaultValue;
    private final String prodDefaultValue;

    public ConfigurationKey(String key, String devDefaultValue, String uatDefaultValue, String prodDefaultValue) {
        this.key = key;
        this.origin = Origin.COMMON;
        this.devDefaultValue = devDefaultValue;
        this.uatDefaultValue = uatDefaultValue;
        this.prodDefaultValue = prodDefaultValue;
    }

    public ConfigurationKey(String key, Origin origin, String devDefaultValue, String uatDefaultValue, String prodDefaultValue) {
        this.key = key;
        this.origin = origin;
        this.devDefaultValue = devDefaultValue;
        this.uatDefaultValue = uatDefaultValue;
        this.prodDefaultValue = prodDefaultValue;
    }

    /**
     * Ritorno il valore di default in base all'ambiente
     * dove mi si è instantiate l'applicazione.
     * @return Ritorno il valore della configurazione
     */
    public String getValue(){
        EnvironmentLabel env = Environment.getInstance().getLabel();
        switch (env){
            case DEV -> {
                return devDefaultValue;
            }
            case UAT -> {
                return uatDefaultValue;
            }
            case PROD -> {
                return prodDefaultValue;
            }
            default ->
                throw ExceptionFactory.create(ExceptionType.NO_ENVIRONMENT_LABEL_FOUND, origin);
        }
    }

}
