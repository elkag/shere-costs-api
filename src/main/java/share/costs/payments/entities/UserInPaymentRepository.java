package share.costs.payments.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInPaymentRepository  extends JpaRepository<UserInPayment, Long> {

}

