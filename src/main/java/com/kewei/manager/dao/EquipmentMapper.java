package com.kewei.manager.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface EquipmentMapper {
	/**
	 * 查询数据库总数
	 * @return
	 */
	int getCncount();

	/**
	 * 查询所有数据
	 * @param pagemap
	 * @return
	 */
	List<Map<String, Object>> findEquipment(Map<String, Object> pagemap);

	/**
	 * 增加、删除
	 * @param xinximap
	 */
	void add1(Map<String, Object> xinximap);

	void del(int id);

	/**
	 * 查询设备名称(去重复查询)
	 * @param modelName
	 * @return
	 */
	List<Map<String , Object>> selectName(Map<String , Object> modelName);
	/**
	 * 查询设备型号
	 * @param modelNumber
	 * @return
	 */
	List<Map<String , Object>> selectModelNumber(Map<String , Object> modelNumber , @Param("name") String name);

	/**
	 * 根据设备名、设备型号查询数据
	 * @param modelNameAndNumber
	 * @param name
	 * @param model_Number
	 * @return
	 */
	List<Map<String , Object>> selectModelNameAndNumber(Map<String , Object> modelNameAndNumber , @Param("name") String name , @Param("model_Number") String model_Number);

}
