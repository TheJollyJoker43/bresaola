package it.giovannipicco.bresaola.exception.bean;


import it.giovannipicco.bresaola.utils.constant.Environment;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FaultInfo {
    private String timeStamp;
    private Environment environment;
    private List<Fault> faultList;
}