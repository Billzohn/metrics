package metrics.rest;

import java.util.List;

import metrics.repo.mybatis.ComplexQueryRepo;
import metrics.rest.dto.AssociationCriteria;
import metrics.rest.dto.AssociationRequest;
import metrics.rest.dto.AssociationResponse;
import metrics.service.AssociationService;
import metrics.util.LogUtilFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/association")
public class AssociationController {
	private Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 根据查询条件筛选出相应的文档
	 * 
	 * @param associationCriteria
	 * @return
	 */
	@Autowired
	private ComplexQueryRepo repo;
	@Autowired
	private AssociationService service;

	@RequestMapping("/queryAssociations")
	public List<AssociationResponse> queryAssociations(
			AssociationCriteria associationCriteria) {
		log.info(LogUtilFilter.getBaseLog() + "业务：查询主题关联度信息");
		Long themeId = associationCriteria.getThemeId();
		if (themeId == null) {
			// 不带有查询条件
			return repo.queryAssociations(associationCriteria);
		} else {
			return repo.queryAssociationsData(associationCriteria);
		}
	}

	@RequestMapping("/queryAssociationsCount")
	public Long queryAssociationsCount(AssociationCriteria associationCriteria) {
		log.info(LogUtilFilter.getBaseLog() + "业务：查询主题关联度信息");
		Long themeId = associationCriteria.getThemeId();
		if (themeId == null) {
			// 不带有查询条件
			return repo.queryAssociationsCount();
		} else {
			return repo.queryAssociationsDataCount(associationCriteria);
		}
	}

	/**
	 * 创建或者更新相关度
	 * 
	 */
	@RequestMapping("/createAssociation")
	public void createAssociation(AssociationRequest associationRequest) {
		log.info(LogUtilFilter.getBaseLog() + "业务：创建主题关联度信息");
		service.createAssociation(associationRequest);
	}

	@RequestMapping("/updateAssociation")
	public void updateAssociation(AssociationRequest associationRequest) {
		log.info(LogUtilFilter.getBaseLog() + "业务：修改主题关联度信息");
		service.updateAssociation(associationRequest);
	}

}
