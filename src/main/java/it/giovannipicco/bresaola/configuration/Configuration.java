package it.giovannipicco.bresaola.configuration;

import it.giovannipicco.bresaola.configuration.dto.ConfigurationDTO;
import it.giovannipicco.bresaola.configuration.dto.ConfigurationRepository;
import it.giovannipicco.bresaola.utils.constant.Environment;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Component che si occupa del recupero e l'utilizzo delle
 * chiavi di configurazione. Se presente recupera quella del db
 * altrimenti recupera la default impostata a codice.
 */
@Log4j2
@Component
public class Configuration {


    //*****************************************
    //************ LOCAL VARIABLES ************
    //*****************************************

    /**
     * Repository per accedere alle chiavi di configurazioni salvate
     * nel database comune in tutta l'applicazione.
     */
    private final ConfigurationRepository repository;
    private final Environment env = Environment.getInstance();

    private List<ConfigurationDTO> cachedValues;

    private LocalDateTime updatedAt;

    public Configuration(ConfigurationRepository repository) {
        this.repository = repository;
        cachedValues = this.repository.findAll();
        updatedAt = LocalDateTime.now();
    }


    //*****************************************
    //************ PRIVATE METHOD *************
    //*****************************************

    /**
     * Controllo se i valori cachati sono più vecchi di 5 minuti
     * @return True se i valori sono più vecchi di 5 minuti, altrimenti False
     */
    private boolean isExpired(){
        boolean b = LocalDateTime.now().minusMinutes(5L).isAfter(updatedAt);
        log.info("isExpired: {}, {}", b, updatedAt);
        return b;
    }

    private String getFromCachedConfiguration(ConfigurationKey config){
        String cv = null;
        for (ConfigurationDTO co : cachedValues) {
            if (co.getKey().equals(config.getKey())
                    && co.getOrigin().equals(config.getOrigin())){
                cv = co.getValue();
                break;
            }
        }
        log.info("Loaded cached configuration \"{}\" -> \"{}\"", config.getKey(), cv);
        return cv;
    }


    /**
     * Eseguo la logica per recuperare il valore della chiave richiesta
     * @param config Configuration Key che si vuole ottenere
     * @return Valore della configurazione
     */
    private String getValue(ConfigurationKey config) {
        if(isExpired()){
            cachedValues = repository.findAll();
            log.info("Loaded new configuration values: {}", cachedValues);
            updatedAt = LocalDateTime.now();
        }
        String cv = getFromCachedConfiguration(config);
        if (cv != null && !cv.isEmpty()){
            return cv;
        }
        return config.getValue();
    }

    //*****************************************
    //************ PUBLIC METHOD **************
    //*****************************************

    /**
     * Restituisco il valore della configurazione in formato stringa
     * @param config Configuration Key che si vuole ottenere
     * @return Stringa con il contenuto della chiave di configurazione
     */
    public String get(ConfigurationKey config){
        return this.getValue(config);
    }

}
