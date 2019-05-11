package cdu.edu.hospital.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.CostDao;
import cdu.edu.hospital.entity.Cost;
import cdu.edu.hospital.util.BaseUtils;

@Service("costService")
public class CostServiceImpl implements CostService{
	
	@Autowired
	CostDao costDao;
	/**
	 * 预交费用保存
	 */
	@Override
	public void costAdd(Cost cost) {
		 costDao.costAdd(cost);
	}
	/**
	 * 预交费用查询
	 */
	@Override
	public List<Map<String, Object>> costQuery(Map map) {
		return costDao.costQuery(map);
	}
	/**
	 * 费用结算
	 */
	@Override
	public List<Map<String, Object>> costTotal(String patientId) {
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
		//预交费用
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("patientId", patientId);
		Map<String,Object> yjcost = costDao.costQueryTotal(map1);
		if(yjcost!=null){
			yjcost.put("type", "预交费用");
			list.add(yjcost);
		}
		//药品费用
		Map<String,Object> drugsCost = costDao.drugsCostQuery(map1);
		if(drugsCost!=null){
			drugsCost.put("type", "领药费用");
			list.add(drugsCost);
		}
		 
		//退药费用
		Map<String,Object> withdrawalCost = costDao.drugWithdrawal(map1);
		if(withdrawalCost!=null){
			withdrawalCost.put("type", "退药费用");
			list.add(withdrawalCost);
		}
		 
		//床位费用
		List<Map<String,Object>> list2 = costDao.bedCodeQuery(map1);
		Map<String, Object> mp = new HashMap<String, Object>(); 
		mp.put("updateTime", new Timestamp(System.currentTimeMillis()));
		mp.put("price", 0);
		list2.add(mp);
		Float total = 0f;

		if(list2!=null){
			for(int i=0;i<list2.size()-1;i++){
				Date date1;
				try {
					date1 = BaseUtils.toDate(list2.get(i+1).get("updateTime").toString());
					Date date2 = BaseUtils.toDate(list2.get(i).get("updateTime").toString()); 
					long days = (date1.getTime()-date2.getTime())/(24*60*60*1000);
					int day = (int)days;
					total = total + day * Float.parseFloat(list2.get(i).get("price").toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}	 
			}
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("patientId", patientId);
			map3.put("account", total);
			map3.put("type", "床位费");
			list.add(map3);
		}
		return list;
	} 
}
