package com.jesustyle.application.entidade.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "phones")
public class Phones {

    @Id
    private long id;

    @OneToMany(mappedBy = "custumer", cascade = CascadeType.ALL)
    private String idCustumer;
    private Phone homePhone; // Make sure Phone is also properly defined
}
