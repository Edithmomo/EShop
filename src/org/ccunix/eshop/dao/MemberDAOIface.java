package org.ccunix.eshop.dao;

import org.ccunix.eshop.model.MemberModel;
/**
 * 会员信息数据库操作类
 * 
 * @author Edith
 * 
 */
public interface MemberDAOIface {
	/**
	 * 通过用户名和密码查询用户信息
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户信息
	 */
	public MemberModel getMemberInfo(String username, String password) ;

	/**
	 * 通过用户名确认该账号是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return 1-存在 0-不存在
	 */
	public int isExistMember(String username);

	/**
	 * 获取会员表id的最大值
	 * 
	 * @return
	 */
	public int getMemberMaxId();

	/**
	 * 添加会员
	 * 
	 * @param memberModel
	 *            会员信息
	 * @return 成功或失败
	 */
	public boolean insertMember(MemberModel memberModel);

	/**
	 * 修该会员信息
	 * 
	 * @param memberModel
	 *            会员
	 * @return 成功 或 失败
	 */
	public boolean updateMember(MemberModel memberModel);
}
