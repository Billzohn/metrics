package metrics.rest;

import java.util.List;

import metrics.model.Theme;
import metrics.repo.mybatis.ComplexQueryRepo;
import metrics.service.ThemeService;
import metrics.util.LogUtilFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theme")
public class ThemeController {
	private Logger log = LoggerFactory.getLogger(ThemeController.class);

	@Autowired
	ThemeService themeService;
	@Autowired
	ComplexQueryRepo complexQueryRepo;

	@RequestMapping("/create")
	public Long create(Theme theme) {
		log.info(LogUtilFilter.getBaseLog() + "业务：创建主题词信息");
		themeService.create(theme);
		return theme.getId();
	}

	@ResponseBody
	@RequestMapping("/findOne")
	public Theme findOne(Long id) {
		log.info(LogUtilFilter.getBaseLog() + "业务：获取单个主题词信息");
		//System.out.println("tttttt"+themeService.findOne(id));
		return themeService.findOne(id);
	}

	@RequestMapping("/update")
	public void update(Theme theme) {
		/*
		 * 必须穿入的字段 Id 将新的信息传入，可改变的字段： 词、频率、状态、拼音；
		 */
		log.info(LogUtilFilter.getBaseLog() + "业务：更新主题词信息");
		themeService.update(theme);
	}

	@RequestMapping("/enabled")
	public void enabled(Long id, Integer dataState) {
		/*
		 * 传入主题的Id，将主题的Id的‘词状态’置为0，标记为不可用
		 */
		log.info(LogUtilFilter.getBaseLog() + "业务：启用/禁用主题词信息");
		themeService.enabled(id, dataState);
	}

	@RequestMapping("/queryThemesCount")
	public Long queryThemesCount(String word) {
		log.info(LogUtilFilter.getBaseLog() + "业务：统计查询主题词分页信息");
		return complexQueryRepo.queryThemseCount(word);
	}

	@RequestMapping("/queryThemes")
	public List<Theme> queryThemes(String word, Integer page, Integer size,
			String direction, String property) {
		log.info(LogUtilFilter.getBaseLog() + "业务：查询主题词信息");
		return complexQueryRepo.queryThemes(word, page, size, direction,
				property);
	}

	@RequestMapping("/queryValidThemes")
	public List<Theme> queryValidThemes() {
		return complexQueryRepo.queryValidThemes();
	}

}
