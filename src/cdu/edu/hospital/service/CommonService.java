package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;
import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;

/**
 * 公共参数服务接口
 * @author 毅
 *
 */
public interface CommonService {
	/**
	 * 职称列表的查询
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
	public List<Parameter>parameterCodeQuery(String code);
	/**
	 * 插入参数信息
	 * @param parameter
	 */
	public void parameterCodeInsert(Parameter parameter);
	/**
	 * 更新参数信息
	 * @param parameter
	 */
	public void parameterCodeUpdate(Parameter parameter);  
	/**
	 * 删除参数信息
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
