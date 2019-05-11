package cdu.edu.hospital.dao;

import java.util.List;
import cdu.edu.hospital.entity.Category;

public interface CategoryDao {
	/**
	 * 病房类型的查询
	 * @param category
	 * @return
	 */
	public List<Category> categoryQuery(Category category);
	/**
	 * 更新病房类型的价格
	 * @param category
	 */
	public void categoryUpdate(Category category);
}
