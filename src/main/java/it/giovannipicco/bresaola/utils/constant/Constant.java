package it.giovannipicco.bresaola.utils.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Constant {
    NA("N/A"),
    ND("N.D."),
    DEFAULT_TIME_FORMAT("MM/dd/yyyy HH:mm:ss");
    private final String constant;
}