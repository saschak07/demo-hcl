package start.myprojectbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.myprojectbe.entity.Asset;

//I prefer to use JpaRepository more than CrudRepository, because
// 1. Has batch support. JPA provides some extra methods related to JPA such as
// delete records in batch and flushing data directly to a database
// 2. JPA repository also extends the PagingAndSorting repository
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}
