package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.Category;

public interface CategoryService {
	
	/**
	 * 查询病房类型
	 * @param category
	 */
	public List<Category> categoryQuery(Category category);
	/**
	 * 更新病房类型的价格
	 * @param category
	 */
	public void categoryUpdate(Category category);
}
