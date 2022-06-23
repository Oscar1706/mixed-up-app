package ojbv.service1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Account {
    @Id
    private Long id;
    private String name;
}
