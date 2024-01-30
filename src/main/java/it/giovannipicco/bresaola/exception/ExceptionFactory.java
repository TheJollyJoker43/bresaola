package it.giovannipicco.bresaola.exception;

import it.giovannipicco.bresaola.exception.bean.*;


import java.util.List;

/**
 * Gestisce la costruzione delle eccezioni e dei suoi componenti
 * permettendo ai micro-servizi di mantenere uno standard.
 */
public class ExceptionFactory {

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType, Throwable cause, List<String> faultValues){
        AbstractException exception = exceptionType.getException();
        exception.addFault(
                new Fault(
                        cause != null ? cause.getMessage() : exceptionType.getFaultKey().name(),
                        exceptionType.getFaultKey().name(),
                        ,
                        exceptionType.getException().getFaultLevel().name(),
                        faultValues
                )
        );
        exception.setHttpStatus(exceptionType.getStatus());
        return exception;
    }

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType, Throwable cause){
        return create(exceptionType, cause, List.of());
    }

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType){
        return create(exceptionType, null, List.of());
    }


}
