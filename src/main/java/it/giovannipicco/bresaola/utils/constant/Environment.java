package it.giovannipicco.bresaola.utils.constant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * Classe che si occupate di recuperare le variabili d'ambiente
 * e tutto ciò che riguarda il sistema in cui sta girando l'applicazione
 */
@Getter
@Log4j2
public class Environment {

    private final String host;
    private final EnvironmentLabel label;
    @JsonIgnore
    private final Origin origin;

    private Environment() {
        this.host = getSystemProperty("HOSTNAME", "LOCAL");
        this.label = EnvironmentLabel.valueOf(
                getSystemProperty("ENVIRONMENT", "DEV").toUpperCase()
        );
        this.origin = Origin.valueOf(
                getSystemProperty("ORIGIN", "COMMON").toUpperCase()
        );
        log.info("Configured Environment: host={}, label={}, origin={}", host, label, origin);
    }

    private static Environment instance;

    /**
     * Recupero dell'istanza di Environment attuale
     * @return Istanza della classe
     */
    public static Environment getInstance(){
        if(instance == null){
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Ritorna il valore della variabile d'ambiente richiesta
     * @param key Chiave della variabile
     * @param def Valore di default nel caso non sia presente la variabile
     * @return Valore della variabile, o il valore di default
     */
    public String getSystemProperty(String key, String def){
        return System.getProperty(key, def);
    }

    /**
     * Ritorna il valore della variabile d'ambiente richiesta
     * @param key Chiave della variabile
     * @return Valore della variabile o stringa vuota se non è presente
     */
    public String getSystemProperty(String key){
        return System.getProperty(key, "");
    }

}