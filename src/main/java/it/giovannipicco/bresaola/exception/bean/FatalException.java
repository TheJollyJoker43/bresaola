package it.giovannipicco.bresaola.exception.bean;

import org.springframework.http.HttpStatus;

public class FatalException extends AbstractException {
    public FatalException() {
    }

    public FatalException(Fault fault) {
        super(fault);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public FaultLevel getFaultLevel() {
        return FaultLevel.FATAL;
    }
}
