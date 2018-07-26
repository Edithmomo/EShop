package org.ccunix.eshop.model;

import java.util.ArrayList;
import java.util.List;

import org.ccunix.eshop.dao.MerchandiseDAO;

public class CastPageModel {
	/**
	 * 数据的总条数
	 */
	private int totalNum;
	/**
	 * 每一页的数据条数
	 */
	private int everyPageNum;
	/**
	 * 总页数
	 */
	private int totalPageNum;
	/**
	 * 当前页码
	 */
	private int nowPage;
	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 上一页
	 */
	private int backPage;
	/**
	 * 是否为特价
	 */
	private String special;
	/**
	 * 查询的商品关键词
	 */
	private String qkey;
	/**
	 * 查询的商品类型
	 */
	private String category;
	/**
	 * 当前页面的商品数据集合
	 */
	private List<MerchandiseModel> currentList = new ArrayList<MerchandiseModel>();
	
	public CastPageModel(int nowPage, int everyPageNum, String special) {
		this.everyPageNum = everyPageNum;
		this.nowPage = nowPage;
		this.special = special;
	}
    
	public CastPageModel(int everyPageNum, int nowPage, String qkey,
			String category) {
		this.everyPageNum = everyPageNum;
		this.nowPage = nowPage;
		this.qkey = qkey;
		this.category = category;
	}
    
	/**
	 * 生成商品当前页信息
	 */
	public void makePageData(){
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		List<MerchandiseModel> merchandiseModels = merchandiseDAO.getMerchandiseListBySpecial(this.special);
		this.totalNum = merchandiseModels.size();
		if(this.totalNum%this.everyPageNum == 0){
			this.totalPageNum = this.totalNum/this.everyPageNum;
		}else{
			this.totalPageNum = this.totalNum/this.everyPageNum+1;
		}
		if(this.nowPage==1){
			this.backPage = 1;
		}else{
			this.backPage = this.nowPage - 1;
		}
		if(this.nowPage==totalPageNum){
			this.nextPage = totalPageNum;
		}else{
			this.nextPage = this.nowPage + 1;
		}
		/**
		 * 1    0-4
		 * 2    5-9
		 */
		for(int i = (this.nowPage-1)*this.everyPageNum;i < (this.nowPage*this.everyPageNum) && i < this.totalNum; i++){
			this.currentList.add(merchandiseModels.get(i));
		}
	}
	
	/**
	 * 生成查询商品结果的当前页信息
	 */
	public void makePageSelectData(){
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		List<MerchandiseModel> merchandiseModels = null;
		if(this.qkey != "" && (this.category == null || category.equals("0"))){
			merchandiseModels = merchandiseDAO.getMerchandiseListByQkey(this.qkey);
		}else if(this.qkey == "" && category != null && !category.equals("0")){
			merchandiseModels = merchandiseDAO.getMerchandiseListByCategory(this.category);
		}else if(this.qkey == "" && category != null && category.equals("0")){
			merchandiseModels = merchandiseDAO.getMerchandiseList();
		}else if(this.qkey != "" && category != null && !category.equals("0")){
			merchandiseModels = merchandiseDAO.getMerchandiseListBySelect(this.qkey, this.category);
		}
		this.totalNum = merchandiseModels.size();
		if(this.totalNum%this.everyPageNum == 0){
			this.totalPageNum = this.totalNum/this.everyPageNum;
		}else{
			this.totalPageNum = this.totalNum/this.everyPageNum+1;
		}
		if(this.nowPage==1){
			this.backPage = 1;
		}else{
			this.backPage = this.nowPage - 1;
		}
		if(this.nowPage==totalPageNum){
			this.nextPage = totalPageNum;
		}else{
			this.nextPage = this.nowPage + 1;
		}
		for(int i = (this.nowPage-1)*this.everyPageNum;i < (this.nowPage*this.everyPageNum) && i < this.totalNum; i++){
			this.currentList.add(merchandiseModels.get(i));
		}
	}
	
	
	public int getTotalNum() {
		return totalNum;
	}

	public int getEveryPageNum() {
		return everyPageNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getBackPage() {
		return backPage;
	}

	public String getSpecial() {
		return special;
	}
    
	public String getQkey() {
		return qkey;
	}

	public String getCategory() {
		return category;
	}

	public List<MerchandiseModel> getCurrentList() {
		return currentList;
	}
}
