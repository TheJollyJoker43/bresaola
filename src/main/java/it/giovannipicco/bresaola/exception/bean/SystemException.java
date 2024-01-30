package it.giovannipicco.bresaola.exception.bean;

import org.springframework.http.HttpStatus;

public class SystemException extends AbstractException {
    public SystemException() {
    }

    public SystemException(Fault fault) {
        super(fault);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public FaultLevel getFaultLevel() {
        return FaultLevel.SYSTEM_UNAVAILABLE;
    }
}
