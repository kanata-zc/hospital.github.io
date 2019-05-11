package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.CategoryDao;
import cdu.edu.hospital.entity.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	/**
	 * 病房类型列表查询
	 */
	@Override
	public List<Category> categoryQuery(Category category) {
		return categoryDao.categoryQuery(category);
	}
	/**
	 * 更新病房类型的价格
	 */
	@Override
	public void categoryUpdate(Category category) {
		categoryDao.categoryUpdate(category);
	}

}
