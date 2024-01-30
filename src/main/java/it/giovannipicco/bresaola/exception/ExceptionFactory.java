package it.giovannipicco.bresaola.exception;

import it.giovannipicco.bresaola.exception.bean.*;
import it.giovannipicco.bresaola.utils.constant.Environment;
import it.giovannipicco.bresaola.utils.constant.Origin;

import java.util.List;

/**
 * Gestisce la costruzione delle eccezioni e dei suoi componenti
 * permettendo ai micro-servizi di mantenere uno standard.
 */
public class ExceptionFactory {

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType, Throwable cause, List<String> faultValues, Origin origin){
        AbstractException exception = exceptionType.getException();
        exception.addFault(
                new Fault(
                        cause != null ? cause.getMessage() : exceptionType.getFaultKey().getValue(),
                        exceptionType.getFaultKey().getKey(),
                        exceptionType.getFaultKey().getValue(),
                        exceptionType.getException().getFaultLevel().name(),
                        origin.name(),
                        faultValues
                )
        );
        exception.setHttpStatus(exceptionType.getStatus());
        return exception;
    }

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType, Throwable cause, Origin origin){
        return create(exceptionType, cause, List.of(), origin);
    }

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType, Throwable cause){
        return create(exceptionType, cause, List.of(), Environment.getInstance().getOrigin());
    }

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType, Origin origin){
        return create(exceptionType, null, List.of(), origin);
    }

    public static <T extends AbstractException> AbstractException create(ExceptionType exceptionType){
        return create(exceptionType, null, List.of(), Environment.getInstance().getOrigin());
    }

}
