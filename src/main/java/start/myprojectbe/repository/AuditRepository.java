package start.myprojectbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.myprojectbe.entity.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
}
