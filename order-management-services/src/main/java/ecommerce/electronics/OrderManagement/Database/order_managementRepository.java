package ecommerce.electronics.OrderManagement.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface order_managementRepository extends JpaRepository<order_management, Long>
{
}
