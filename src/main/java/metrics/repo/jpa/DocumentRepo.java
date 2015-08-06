package metrics.repo.jpa;

import metrics.model.Document;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, Long> {

}
