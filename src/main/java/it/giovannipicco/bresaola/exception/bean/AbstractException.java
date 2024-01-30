package it.giovannipicco.bresaola.exception.bean;

import it.giovannipicco.bresaola.utils.constant.Environment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public abstract class AbstractException extends RuntimeException {

    private HttpStatus httpStatus;
    private FaultInfo faultInfo;

    protected AbstractException(){
        this.faultInfo =
                new FaultInfo(
                        LocalDateTime.now().toString(),
                        Environment.getInstance(),
                        new ArrayList<>()
                );
    }

    protected AbstractException(Fault fault){
        this.faultInfo =
                new FaultInfo(
                        LocalDateTime.now().toString(),
                        Environment.getInstance(),
                        new ArrayList<>()
                );
        faultInfo.getFaultList().add(fault);
    }

    public void addFault(Fault fault){
        fault.setFaultLevel(this.getFaultLevel().name());
        faultInfo.getFaultList().add(fault);
    }

    public abstract HttpStatus getHttpStatus();

    public abstract FaultLevel getFaultLevel();

}
