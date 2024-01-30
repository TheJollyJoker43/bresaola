package it.giovannipicco.bresaola.configuration.dto;

import it.giovannipicco.bresaola.utils.constant.EnvironmentLabel;
import it.giovannipicco.bresaola.utils.constant.Origin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "configuration")
@Table(name = "configuration")
public class ConfigurationDTO {

    @Id
    private String key;
    private String value;
    @Enumerated(EnumType.STRING)
    private EnvironmentLabel env;
    @Enumerated(EnumType.STRING)
    private Origin origin;

}
