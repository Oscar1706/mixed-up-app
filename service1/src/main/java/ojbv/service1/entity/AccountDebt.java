package ojbv.service1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class AccountDebt {

    @Id
    private Long id;
    private String status;
    private double totalAmount;

}
