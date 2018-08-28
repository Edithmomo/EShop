package org.ccunix.eshop.dao;

import java.util.List;
import org.ccunix.eshop.model.CategoryModel;

/**
 * 书籍分类的数据库访问接口
 * @author Administrator
 *
 */
public interface CategoryDAOIface {
	/**
	 * 获取所有的书籍目录名
	 * @return 目录名集合
	 */
	public List<CategoryModel> getCategoryList();
	
	/**
	 * 通过书籍目录id 查询目录
	 * @param id 目录id
	 * @return 目录信息
	 */
	public CategoryModel getCategoryById(int id);
}
