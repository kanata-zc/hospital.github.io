package cdu.edu.hospital.dao;

import java.util.List;

import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;

/**
 * 公共参数管理
 * @author 毅
 *
 */
public interface CommonDao {
	/**
	 * 职称列表查询
	 * @return
	 */
	public List<Common> titleQuery(String name);
	/**
	 * 参数查询
	 * @return
	 */
	public List<Parameter> parameterQuery();
	/**
	 * 参数列表查询
	 * @param code
	 * @return
	 */
	public List<Parameter> parameterCodeQuery(String code);
	/**
	 * 参数插入
	 * @param parameter
	 */
	public void parameterCodeInsert(Parameter parameter);
	/**
	 * 参数更新
	 * @param parameter
	 */
	public void parameterCodeUpdate(Parameter parameter);
	/**
	 * 参数删除
	 * @param id
	 */
	public void parameterCodeDelete(Integer id);
	
	/**
	 * 病房类型查询
	 * @return
	 */
	public List<Parameter> wardTypeQuery();
	/**
	 * 民族列表查询
	 * @return
	 */
	public List<Parameter> nationQuery();
	 
}
