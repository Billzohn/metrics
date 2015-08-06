package metrics.service;

import java.util.Date;

import metrics.model.Document;
import metrics.repo.jpa.DocumentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class DocumentService {
	@Autowired
	DocumentRepo documentRepo;
	@Transactional
	public void create(Document document) {
		document.setCreated(new Date());
		document.setUpdated(document.getCreated());
		document.setDataState(1);
		documentRepo.save(document);
	}
	@Transactional
	public void update(Document document) {
		Document doc = documentRepo.getOne(document.getId());
		if(document.getMerchandiseId()!=null && !"".equals(document.getMerchandiseId())){
			doc.setMerchandiseId(document.getMerchandiseId());
		}
		if(document.getMerchandiseName()!=null && !"".equals(document.getMerchandiseName())){
			doc.setMerchandiseName(document.getMerchandiseName());
		}
		if(document.getBrandCN()!=null && !"".equals(document.getBrandCN())){
			doc.setBrandCN(document.getBrandCN());
		}
		if(document.getBrandEN()!=null && !"".equals(document.getBrandEN())){
			doc.setBrandEN(document.getBrandEN());
		}
		if(document.getFirstCategory()!=null && !"".equals(document.getFirstCategory())){
			doc.setFirstCategory(document.getFirstCategory());
		}
		if(document.getSecondCategory()!=null && !"".equals(document.getSecondCategory())){
			doc.setSecondCategory(document.getSecondCategory());
		}
		if(document.getThirdCategory()!=null && !"".equals(document.getThirdCategory())){
			doc.setThirdCategory(document.getThirdCategory());
		}
		if(document.getFourthCategory()!=null && !"".equals(document.getFourthCategory())){
			doc.setFourthCategory(document.getFourthCategory());
		}
		if(document.getColor()!=null && !"".equals(document.getColor())){
			doc.setColor(document.getColor());
		}
		if(document.getGender()!=null && !"".equals(document.getGender())){
			doc.setGender(document.getGender());
		}
		if(document.getDataState()!=null && !"".equals(document.getDataState())){
			doc.setDataState(document.getDataState());
		}
		doc.setUpdated(new Date());
//		documentRepo.save(doc);
	}
	@Transactional
	public Document findOne(Long id) {
		Document document = documentRepo.findOne(id);

		return document;
	}
	@Transactional
	public void enabled(Long id, Integer dataState) {
		Document doc = documentRepo.findOne(id);
		doc.setDataState(dataState);
		documentRepo.save(doc);
	}

	
}
