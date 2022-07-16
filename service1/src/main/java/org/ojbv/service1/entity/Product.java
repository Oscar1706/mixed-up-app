package org.ojbv.service1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {

  @Id @NonNull private Long id;
  @NonNull private String code;
  @NonNull private String name;
  @NonNull private LocalDateTime addedDate;

  public void fillFrom(Product another) {
    this.code = another.getCode();
    this.name = another.getName();
    this.addedDate = another.getAddedDate();
  }
}
