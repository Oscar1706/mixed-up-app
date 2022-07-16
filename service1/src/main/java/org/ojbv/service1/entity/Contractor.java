package org.ojbv.service1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Contractor {

  @Id @NonNull private Long id;
  @NonNull private String name;

  public void fillFrom(Contractor another) {
    this.name = another.getName();
  }
}
