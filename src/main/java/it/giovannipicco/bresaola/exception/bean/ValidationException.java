package it.giovannipicco.bresaola.exception.bean;

import org.springframework.http.HttpStatus;

public class ValidationException extends AbstractException {
    public ValidationException() {
    }

    public ValidationException(Fault fault) {
        super(fault);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public FaultLevel getFaultLevel() {
        return FaultLevel.VALIDATION_ERROR;
    }
}
