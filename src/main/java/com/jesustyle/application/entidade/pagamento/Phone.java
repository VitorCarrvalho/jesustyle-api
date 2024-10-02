package com.jesustyle.application.entidade.pagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String areaCode;
    private String number;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Phones phones;
}
