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
public class Sale {

  @Id @NonNull private Long id;

  public void fillFrom(Sale another) {}
}
