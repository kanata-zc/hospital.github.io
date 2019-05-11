 package cdu.edu.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.CommonDao;
import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;

@Service("commonService")
public class CommonServiceImpl implements CommonService{
	
	@Autowired //注入的组件ID是 commonDao
	private  CommonDao commonDao;
	
	/**
	 * 查询职称列表
	 */
	@Override
	public List<Common> titleQuery(String name) {
		return commonDao.titleQuery(name);
	}
	/**
	 * 参数查询
	 */
	@Override
	public List<Parameter> parameterQuery() {
		return commonDao.parameterQuery();
	}
	/**
	 * 参数列表查询
	 */
	@Override
	public List<Parameter> parameterCodeQuery(String code) {
		return commonDao.parameterCodeQuery(code);
	}
	/**
	 * 参数插入
	 */
	@Override
	public void parameterCodeInsert(Parameter parameter) {
		commonDao.parameterCodeInsert(parameter);
	}
	/**
	 * 参数更新
	 */
	@Override
	public void parameterCodeUpdate(Parameter parameter) {
		 commonDao.parameterCodeUpdate(parameter);
		
	}
	/**
	 * 删除参数信息
	 */
	@Override
	public void parameterCodeDelete(Integer id) {
		commonDao.parameterCodeDelete(id);
	}
	/**
	 * 病房类型查询
	 */
	@Override
	public List<Parameter> wardTypeQuery() {
		return commonDao.wardTypeQuery();
	}
	/**
	 * 民族列表查询
	 */
	@Override
	public List<Parameter> nationQuery() {
		return commonDao.nationQuery();
	}

}
