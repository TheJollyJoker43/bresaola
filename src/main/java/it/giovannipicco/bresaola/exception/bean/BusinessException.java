package it.giovannipicco.bresaola.exception.bean;

import org.springframework.http.HttpStatus;

public class BusinessException extends AbstractException {
    public BusinessException() {
    }

    public BusinessException(Fault fault) {
        super(fault);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public FaultLevel getFaultLevel() {
        return FaultLevel.BUSINESS;
    }
}
