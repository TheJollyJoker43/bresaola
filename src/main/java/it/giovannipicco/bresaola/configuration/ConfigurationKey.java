package it.giovannipicco.bresaola.configuration;

import it.giovannipicco.bresaola.exception.ExceptionConfiguration;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ConfigurationKey {

    CONFIUGURATION_TEST(
            "",
            "",
            "",
            ""
    ),
    UNMANAGED_ERROR(
            "Errore non gestito",
            "Errore non gestito",
            "Errore non gestito",
            "Errore non gestito"
    ),

    NO_ENVIRONMENT_LABEL_FOUND(
            "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione",
            "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione",
            "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione",
            "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione"
    ),

    NOT_VALID_REQUEST(
            "La richiesta non è valida, si prega di controllare i parametri in ingresso",
            "La richiesta non è valida, si prega di controllare i parametri in ingresso",
            "La richiesta non è valida, si prega di controllare i parametri in ingresso",
            "La richiesta non è valida, si prega di controllare i parametri in ingresso"
    ),

    NOT_EMPTY (
            "Ci sono campi non validi o vuoti",
            "Ci sono campi non validi o vuoti",
            "Ci sono campi non validi o vuoti",
            "Ci sono campi non validi o vuoti"
    ),

    NO_MATCH_WITH_REGEX (
            "Alcuni campi non coincidono con il pattern aspettato",
            "Alcuni campi non coincidono con il pattern aspettato",
            "Alcuni campi non coincidono con il pattern aspettato",
            "Alcuni campi non coincidono con il pattern aspettato"
    ),

    ENTITY_ALREADY_PRESENT (
            "Sembra sia già presente un elemento con le stesse proprietà",
            "Sembra sia già presente un elemento con le stesse proprietà",
            "Sembra sia già presente un elemento con le stesse proprietà",
            "Sembra sia già presente un elemento con le stesse proprietà"
    ),

    ENTITY_NOT_PRESENT (
            "Sembra che l'elemento che si vuole recuperare non esita",
            "Sembra che l'elemento che si vuole recuperare non esita",
            "Sembra che l'elemento che si vuole recuperare non esita",
            "Sembra che l'elemento che si vuole recuperare non esita"
    ),

    NOT_IN_THE_ENUM (
            "Sembra che l'elemento con corrisponda con la numerazione interna",
            "Sembra che l'elemento con corrisponda con la numerazione interna",
            "Sembra che l'elemento con corrisponda con la numerazione interna",
            "Sembra che l'elemento con corrisponda con la numerazione interna"
    ),

    PAGEABLE_PAGE_IS_NOT_AN_INTEGER(
            "Il parametro 'page' non è un intero, per favore controlla quanto inserito",
            "Il parametro 'page' non è un intero, per favore controlla quanto inserito",
            "Il parametro 'page' non è un intero, per favore controlla quanto inserito",
            "Il parametro 'page' non è un intero, per favore controlla quanto inserito"
    ),

    PAGEABLE_SIZE_IS_NOT_AN_INTEGER (
            "Il parametro 'size' non è un intero, per favore controlla quanto inserito",
            "Il parametro 'size' non è un intero, per favore controlla quanto inserito",
            "Il parametro 'size' non è un intero, per favore controlla quanto inserito",
            "Il parametro 'size' non è un intero, per favore controlla quanto inserito"
    ),

    PAGEABLE_MISSING_ARGUMENT (
            "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)",
            "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)",
            "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)",
            "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)"
    ),

    GET_BY_ID_KO(
            "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi",
            "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi",
            "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi",
            "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi"
    ),
    GET_ALL_KO(
            "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi",
            "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi",
            "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi",
            "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi"
    ),
    ADD_KO(
            "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi"
    ),
    EDIT_KO(
            "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi"
    ),
    DELETE_KO(
            "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi",
            "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi"
    );

    private final String localDefaultValue;
    private final String devDefaultValue;
    private final String uatDefaultValue;
    private final String prodDefaultValue;

    public String getDefaultValue(String env){
        return switch (env) {
            case "DEV" -> devDefaultValue;
            case "UAT" -> uatDefaultValue;
            case "PROD" -> prodDefaultValue;
            default -> localDefaultValue;
        };
    }



}
