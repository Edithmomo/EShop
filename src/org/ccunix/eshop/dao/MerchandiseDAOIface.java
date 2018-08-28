package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.eshop.model.MerchandiseModel;
import org.ccunix.eshop.util.DBManager;
/**
 * 书籍数据库操作类
 * @author Edith
 *
 */
public interface MerchandiseDAOIface {
	/**
	 * 查询所以的书籍信息
	 * @return  书籍集合
	 */
	public List<MerchandiseModel> getMerchandiseList();
	
	/**
	 * 通过special 查询书籍
	 * @param special 是否为特价    1-是   0-新品
	 * @return 特价书籍集合或新品书籍集合
	 */
	public List<MerchandiseModel> getMerchandiseListBySpecial(int special);
	
	/**
	 * 通过id查询商品信息
	 * @param id 商品id
	 * @return 商品信息
	 */
	public MerchandiseModel getOneMerchandiseById(int id);
	
	/**
	 * 通过书籍关键字和书籍分类目录查询
	 * @param qKey 书籍关键字      与书籍名匹配
	 * @param category 书籍目录id
	 * @return 书籍信息集合
	 */
	public List<MerchandiseModel> getMerchandiseListBySelect(String qKey,int category);
	
	/**
	 * 通过书籍分类目录查询
	 * @param category 书籍目录id
	 * @return 书籍信息集合
	 */
	public List<MerchandiseModel> getMerchandiseListByCategory(int category);
	
	/**
	 * 通过书籍关键字查询
	 * @param qKey 书籍关键字      与书籍名匹配
	 * @return 书籍信息集合
	 */
	public List<MerchandiseModel> getMerchandiseListByQkey(String qKey);
}
