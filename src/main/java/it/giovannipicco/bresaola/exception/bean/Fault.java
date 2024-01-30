package it.giovannipicco.bresaola.exception.bean;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Fault {
    private String cause;
    private String faultKey;
    private String faultMessage;
    private String faultLevel;
    private String origin;
    private List<String> invalidFields;
}