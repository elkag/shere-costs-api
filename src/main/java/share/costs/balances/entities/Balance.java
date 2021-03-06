package share.costs.balances.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import share.costs.constants.Constants;
import share.costs.groups.entities.GroupUserBalance;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // How much ows the group or the group owes to user
    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    // How much the user gave to the group
    @Column(name = "spending", nullable = false)
    private BigDecimal spending = BigDecimal.ZERO;

    // What the user has to pay
    @Column(name = "costs", nullable = false)
    private BigDecimal costs = BigDecimal.ZERO;

    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate = new Date();

    @OneToMany(mappedBy = "balance", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<GroupUserBalance> groupUserBalance = null;
}
