package start.myprojectbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.myprojectbe.entity.Order;

//I prefer to use JpaRepository more than CrudRepository, because
// 1. Has batch support. JPA provides some extra methods related to JPA such as
// delete records in batch and flushing data directly to a database
// 2. JPA repository also extends the PagingAndSorting repository
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
