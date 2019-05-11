package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.Bed;

public interface BedService {
	/**
	 * 床位查询
	 * @param bed
	 * @return
	 */
	public List<Bed> bedQuery(Bed bed);	
	
	/**
	 * 更改床位状态
	 * @param bed
	 */
	public void bedUpdate(Bed bed);
	
	/**
	 * 查询房间是否已满
	 * @param bed
	 * @return
	 */
	public Integer bedStateQuery(Bed bed);
}
