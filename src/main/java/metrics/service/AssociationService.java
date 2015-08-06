package metrics.service;

import java.util.ArrayList;
import java.util.List;

import metrics.model.Association;
import metrics.model.Document;
import metrics.model.Theme;
import metrics.repo.jpa.AssociationRepo;
import metrics.repo.jpa.DocumentRepo;
import metrics.repo.jpa.ThemeRepo;
import metrics.rest.dto.AssociationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AssociationService {
	@Autowired
	private AssociationRepo repo;
	@Autowired
	private DocumentRepo drepo;
	@Autowired
	private ThemeRepo trepo;
	
	@Transactional
	public void createAssociation(AssociationRequest associationRequest) {
		//创建一个theme对象
		Theme th = trepo.findOne(associationRequest.getThemeId());
		
		//创建一个document对象
		Document doc = drepo.findOne(associationRequest.getDocumentId());
		
		//创建一个相关度对象 act
		Association act = new Association();
		//为act对象设置值
		act.setName(associationRequest.getName());
		act.setValue(associationRequest.getValue());
		act.setWord(associationRequest.getWord());
		act.setDocument(doc);
		act.setTheme(th);
		
		List<Association> list = new ArrayList<Association>();
		list.add(act);
		
		th.setAssociations(list);
		
		repo.save(act);
	}
	
	@Transactional
	public void updateAssociation(AssociationRequest associationRequest) {
		
		Association a = repo.findOneAssociation(associationRequest.getDocumentId(), associationRequest.getThemeId());
		a.setValue(associationRequest.getValue());
		
		
	}
	
}
