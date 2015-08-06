package metrics.service;

import java.util.Date;

import metrics.model.Theme;
import metrics.repo.jpa.ThemeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ThemeService {
	@Autowired
	private ThemeRepo themeRepo;

	@Transactional
	public void create(Theme theme) {
		theme.setCreated(new Date());
		theme.setUpdated(theme.getCreated());
		theme.setDataState(1);
		themeRepo.save(theme);
	}

	@Transactional
	public void update(Theme theme) {
		Theme themeDb = themeRepo.findOne(theme.getId());
		themeDb.setUpdated(new Date());
		if(theme.getDataState()!=null && !"".equals(theme.getDataState())){
			themeDb.setDataState(theme.getDataState());
		}
		if(theme.getPinyin()!=null && !"".equals(theme.getPinyin())){
			themeDb.setPinyin(theme.getPinyin());
		}
		if(theme.getWord()!=null && !"".equals(theme.getWord())){
			themeDb.setWord(theme.getWord());
		}
		if(theme.getSearchFrequency()!=null && !"".equals(theme.getSearchFrequency())){
			themeDb.setSearchFrequency(theme.getSearchFrequency());
		}
		themeRepo.save(themeDb);
	}
	@Transactional
	public Theme findOne(Long id) {
		Theme theme = themeRepo.findOne(id);
		//System.out.println(theme.getAssociations());
		return theme;
	}

	@Transactional
	public void enabled(Long id, Integer status) {
		Theme theme = themeRepo.findOne(id);
		theme.setDataState(status);
		themeRepo.save(theme);
	}
	
	

}
