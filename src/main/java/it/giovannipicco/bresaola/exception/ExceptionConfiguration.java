package it.giovannipicco.bresaola.exception;

import it.giovannipicco.bresaola.configuration.ConfigurationKey;
import it.giovannipicco.bresaola.utils.constant.Origin;

public class ExceptionConfiguration extends ConfigurationKey {

    public ExceptionConfiguration(String key, String devDefaultValue, String uatDefaultValue, String prodDefaultValue) {
        super(key, devDefaultValue, uatDefaultValue, prodDefaultValue);
    }

    public ExceptionConfiguration(String key, Origin origin, String devDefaultValue, String uatDefaultValue, String prodDefaultValue) {
        super(key, origin, devDefaultValue, uatDefaultValue, prodDefaultValue);
    }

    public static ExceptionConfiguration UNMANAGED_ERROR =
            new ExceptionConfiguration(
                    "exception.unmanaged.error",
                    "Errore non gestito",
                    "Errore non gestito",
                    "Errore non gestito"
            );

    public static final ExceptionConfiguration NO_ENVIRONMENT_LABEL_FOUND =
            new ExceptionConfiguration(
                    "exception.no.environment.label.found",
                    "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione",
                    "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione",
                    "Non è stato possibile trovare il valore dell'ambiente per il quale si vuole eseguire l'applicazione"
            );

    public static ExceptionConfiguration NOT_VALID_REQUEST =
            new ExceptionConfiguration(
                    "exception.not.valid.request",
                    "La richiesta non è valida, si prega di controllare i parametri in ingresso",
                    "La richiesta non è valida, si prega di controllare i parametri in ingresso",
                    "La richiesta non è valida, si prega di controllare i parametri in ingresso"
            );

    public static ExceptionConfiguration NOT_EMPTY =
            new ExceptionConfiguration(
                    "exception.not.empty",
                    "Ci sono campi non validi o vuoti",
                    "Ci sono campi non validi o vuoti",
                    "Ci sono campi non validi o vuoti"
            );

    public static ExceptionConfiguration NO_MATCH_WITH_REGEX =
            new ExceptionConfiguration(
                    "exception.no.match.with.regex",
                    "Alcuni campi non coincidono con il pattern aspettato",
                    "Alcuni campi non coincidono con il pattern aspettato",
                    "Alcuni campi non coincidono con il pattern aspettato"
            );

    public static ExceptionConfiguration ENTITY_ALREADY_PRESENT =
            new ExceptionConfiguration(
                    "exception.entity.already.present",
                    "Sembra sia già presente un elemento con le stesse proprietà",
                    "Sembra sia già presente un elemento con le stesse proprietà",
                    "Sembra sia già presente un elemento con le stesse proprietà"
            );

    public static ExceptionConfiguration ENTITY_NOT_PRESENT =
            new ExceptionConfiguration(
                    "exception.entity.not.present",
                    "Sembra che l'elemento che si vuole recuperare non esita",
                    "Sembra che l'elemento che si vuole recuperare non esita",
                    "Sembra che l'elemento che si vuole recuperare non esita"
            );

    public static ExceptionConfiguration NOT_IN_THE_ENUM =
            new ExceptionConfiguration(
                    "exception.not.in.the.enum",
                    "Sembra che l'elemento con corrisponda con la numerazione interna",
                    "Sembra che l'elemento con corrisponda con la numerazione interna",
                    "Sembra che l'elemento con corrisponda con la numerazione interna"
            );

    public static ExceptionConfiguration PAGEABLE_PAGE_IS_NOT_AN_INTEGER =
            new ExceptionConfiguration(
                    "exception.pageable.page.is.not.an.integer",
                    "Il parametro 'page' non è un intero, per favore controlla quanto inserito",
                    "Il parametro 'page' non è un intero, per favore controlla quanto inserito",
                    "Il parametro 'page' non è un intero, per favore controlla quanto inserito"
            );

    public static ExceptionConfiguration PAGEABLE_SIZE_IS_NOT_AN_INTEGER =
            new ExceptionConfiguration(
                    "exception.pageable.size.is.not.an.integer",
                    "Il parametro 'size' non è un intero, per favore controlla quanto inserito",
                    "Il parametro 'size' non è un intero, per favore controlla quanto inserito",
                    "Il parametro 'size' non è un intero, per favore controlla quanto inserito"
            );

    public static ExceptionConfiguration PAGEABLE_MISSING_ARGUMENT =
            new ExceptionConfiguration(
                    "exception.pageable.missing.argument",
                    "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)",
                    "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)",
                    "Sembra che tu stia richiedendo una pagina, ma mancano dei parametri. Per favore assicurati di fornire: page, size e sort(opzionale)"
            );

    public static final ExceptionConfiguration GET_BY_ID_KO =
            new ExceptionConfiguration(
                    "exception.get.by.id.ko",
                    "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi",
                    "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi",
                    "Errore nel recupero dell'oggetto per ID, controlla la tua richiesta o riprova più tardi"
            );

    public static final ExceptionConfiguration GET_ALL_KO =
            new ExceptionConfiguration(
                    "exception.get.all.ko",
                    "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi",
                    "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi",
                    "Errore nel recupero della lista di oggetti, controlla la tua richiesta o riprova più tardi"
            );

    public static final ExceptionConfiguration ADD_KO =
            new ExceptionConfiguration(
                    "exception.add.ko",
                    "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi",
                    "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi",
                    "Errore nell'aggiunta di un nuovo oggetto, controlla la tua richiesta o riprova più tardi"
            );

    public static final ExceptionConfiguration EDIT_KO =
            new ExceptionConfiguration(
                    "exception.edit.ko",
                    "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi",
                    "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi",
                    "Errore nella modifica dell'oggetto, controlla la tua richiesta o riprova più tardi"
            );

    public static final ExceptionConfiguration DELETE_KO =
            new ExceptionConfiguration(
                    "exception.delete.ko",
                    "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi",
                    "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi",
                    "Errore nell'eliminazione dell'oggetto, controlla la tua richiesta o riprova più tardi"
            );

}
