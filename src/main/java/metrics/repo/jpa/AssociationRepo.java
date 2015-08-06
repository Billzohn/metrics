package metrics.repo.jpa;

import metrics.model.Association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssociationRepo extends JpaRepository<Association, Long> {
	
	@Query("from Association a where a.document.id=?1 and a.theme.id=?2")
	Association findOneAssociation(Long documentId,Long themeId);
	
}
