package it.giovannipicco.bresaola.exception;

import it.giovannipicco.bresaola.exception.bean.BusinessException;
import it.giovannipicco.bresaola.exception.bean.FatalException;
import it.giovannipicco.bresaola.exception.bean.SystemException;
import it.giovannipicco.bresaola.exception.bean.ValidationException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@AllArgsConstructor
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException ve) {
        log.error(ve);
        return ResponseEntity.status(ve.getHttpStatus()).body(ve.getFaultInfo());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException be) {
        log.error(be);
        return ResponseEntity.status(be.getHttpStatus()).body(be.getFaultInfo());
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<Object> handleSystemException(SystemException se) {
        log.error(se);
        return ResponseEntity.status(se.getHttpStatus()).body(se.getFaultInfo());
    }

    @ExceptionHandler(FatalException.class)
    public ResponseEntity<Object> handleFatalException(FatalException fe) {
        log.error(fe);
        return ResponseEntity.status(fe.getHttpStatus()).body(fe.getFaultInfo());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        log.error(ex);
        FatalException exception = (FatalException) ExceptionFactory.create(ExceptionType.UNMANAGED_ERROR, ex);
        return ResponseEntity.status(exception.getHttpStatus()).body(exception.getFaultInfo());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error(ex);
        ValidationException exception = (ValidationException) ExceptionFactory.create(ExceptionType.INVALID_REQUEST, ex);
        return ResponseEntity.status(exception.getHttpStatus()).body(exception.getFaultInfo());
    }

}