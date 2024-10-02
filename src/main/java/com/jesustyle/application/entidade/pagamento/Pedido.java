import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jesustyle.application.entidade.pagamento.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "PedidoEntity")
public class Pedido {

    @Id
    private String id;

    private String code;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Items> items; // Certifique-se de que o nome do campo em Items é "pedido"

    private Phone phone;
    private Phones phones;
    private Customer customer;
    private BillingAddress billingAddress;
    private Card card;
    private CreditCard creditCard;

    @JsonProperty("payments")
    private List<Payments> payments;

    private OrderRequest orderRequest;
}