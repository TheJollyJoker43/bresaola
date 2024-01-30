package it.giovannipicco.bresaola.configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "configuration")
@Entity(name = "configuration")
public class Configuration {

    @Id
    private String key;
    private String value;

}
