package org.ojbv.service1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class AccountEntry {

  @Id @NonNull private Long id;
  // Absolute value of the transaction
  // the sign is given by the movement type:
  //  Sale (+) adds to the account balance
  //  Payment (-) substract from th account balance
  @NonNull private Double amount;
  // Sale or Payment
  @NonNull private String transactionType;
  // Account balance once the transaction is done
  @NonNull private Double balanceAfter;
  @NonNull private LocalDateTime transactionDate;

  public void fillFrom(AccountEntry another) {
    this.amount = another.getAmount();
    this.transactionType = another.getTransactionType();
    this.balanceAfter = another.getBalanceAfter();
    this.transactionDate = another.getTransactionDate();
  }
}
