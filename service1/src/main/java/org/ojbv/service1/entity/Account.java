package org.ojbv.service1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Account {
    @Id
    @NonNull
    private Long id;
    @NonNull
    private Double balance;
    @NonNull
    private String status;
    @NonNull
    private LocalDateTime addedDate;
    @NonNull
    private String comment;

    /**
     * Fills instance values (except id) from
     * another instance.
     * */
    public void fillFrom(Account otherAccount){
        this.balance = otherAccount.getBalance();
        this.status = otherAccount.getStatus();
        this.addedDate = otherAccount.getAddedDate();
        this.comment = otherAccount.getComment();
    }
}
