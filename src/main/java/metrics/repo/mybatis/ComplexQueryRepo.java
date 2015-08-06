package metrics.repo.mybatis;

import java.util.List;

import metrics.model.Document;
import metrics.model.Theme;
import metrics.model.User;
import metrics.rest.dto.AssociationCriteria;
import metrics.rest.dto.AssociationResponse;
import metrics.rest.dto.DocumentQueryCriteria;

import org.apache.ibatis.annotations.Param;


/**
 * 综合复杂查询<br>
 * 
 * 
 * @author percy
 *
 */
public interface ComplexQueryRepo {
	
	/*
	 * 根据 分页条件 查询  查询主题 
	 * */
	Long queryThemseCount(@Param("word")String word);

	Long queryThemseCount(@Param("page")Integer page,
							@Param("size") Integer size,
							@Param("direction")String direction,
							@Param("property")String property);
	
	List<Theme> queryThemes(@Param("page")Integer page,
							 @Param("size") Integer size,
							 @Param("direction")String direction,
							 @Param("property")String property);
	List<Theme> queryValidThemes();
	/*
	 * 根据 条件 查询主题
	 * */
	List<Theme> queryThemesByField(Theme theme);
	
	List<Theme> queryThemes(@Param("word") String word,
			@Param("page") Integer page, @Param("size") Integer size,
			@Param("direction") String direction,
			@Param("property") String property);
	
	
	Long queryDocumentsCount(DocumentQueryCriteria queryCriteria);

	List<Document> queryDocuments(DocumentQueryCriteria queryCriteria);

	
	
	
	/*
	 * 相关度查询
	 * */
	//带有查询条件
	List<AssociationResponse> queryAssociationsData(AssociationCriteria associationCriteria);
	
	Long queryAssociationsDataCount(AssociationCriteria associationCriteria);
	
	List<AssociationResponse> queryAssociations(AssociationCriteria associationCriteria);
	
	//没有查询条件
	Long queryAssociationsCount();
	//没有查询条件
	User queryUser(@Param("name") String name,@Param("pass") String pass);
}
