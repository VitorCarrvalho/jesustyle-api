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

    @ManyToOne
    @JoinColumn(name = "id") // Substitua por como você nomeou a chave estrangeira na tabela
    private Customer customer; // Altere de String para Customer

    @ManyToOne
    @JoinColumn(name = "id")
    private Phone homePhone; // Certifique-se de que Phone também está devidamente definido
}