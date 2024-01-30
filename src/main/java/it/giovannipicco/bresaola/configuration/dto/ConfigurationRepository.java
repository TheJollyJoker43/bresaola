package it.giovannipicco.bresaola.configuration.dto;

import it.giovannipicco.bresaola.utils.constant.EnvironmentLabel;
import it.giovannipicco.bresaola.utils.constant.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository per accedere alle configurazioni dell'applicazione, microservizio.
 */
@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationDTO, String> {

    /**
     * Recupero la configurazione richiesta dal database
     * @param key Valore della chiave di configurazione
     * @param env Ambiente per la quale si vuole la configurazione
     * @param origin Microservizo alla quale la configurazione appartiene
     * @return Oggetto contente tutte le informazioni necessarie
     */
    Optional<ConfigurationDTO> getByKeyAndEnvAndOrigin(String key, EnvironmentLabel env, Origin origin);

}
