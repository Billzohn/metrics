package metrics.rest;

import java.util.List;

import metrics.model.Document;
import metrics.repo.mybatis.ComplexQueryRepo;
import metrics.rest.dto.DocumentQueryCriteria;
import metrics.service.DocumentService;
import metrics.util.LogUtilFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	DocumentService documentService;
	@Autowired
	ComplexQueryRepo complexQueryRepo;

	@RequestMapping("/create")
	public Long create(Document document) {
		log.info(LogUtilFilter.getBaseLog() + "业务：创建文档信息");
		documentService.create(document);
		return document.getId();
	}

	@RequestMapping("/update")
	public void update(Document document) {
		log.info(LogUtilFilter.getBaseLog() + "业务：更新文档信息");
		documentService.update(document);
	}

	@RequestMapping("/findOne")
	public Document findOne(Long id) {
		log.info(LogUtilFilter.getBaseLog() + "业务：获取单个文档信息");
		return documentService.findOne(id);
	}

	@RequestMapping("/enabled")
	public void enabled(Long id, Integer dataState) {
		log.info(LogUtilFilter.getBaseLog() + "业务：启用/禁用文档信息");
		documentService.enabled(id, dataState);
	}

	@RequestMapping("/queryDocumentsCount")
	public Long queryDocumentsCount(DocumentQueryCriteria queryCriteria) {
		log.info(LogUtilFilter.getBaseLog() + "业务：统计文档信息");
		return complexQueryRepo.queryDocumentsCount(queryCriteria);
	}

	@RequestMapping("/queryDocuments")
	public List<Document> queryDocuments(DocumentQueryCriteria queryCriteria) {
		log.info(LogUtilFilter.getBaseLog() + "业务：查询文档信息");
		return complexQueryRepo.queryDocuments(queryCriteria);
	}

}
