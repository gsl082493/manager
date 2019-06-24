package com.kewei.manager.service.impl;

import com.kewei.manager.dao.EquipmentMapper;
import com.kewei.manager.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class EquipmentServiceImpl  implements EquipmentService {

	@Autowired
	private EquipmentMapper equipmentMapper;

	public int getCncount() {
		int num=equipmentMapper.getCncount();
		return num;
	}
	public List<Map<String, Object>> findEquipment(Map<String, Object> pagemap) {
		List<Map<String, Object>> equipmentlist=equipmentMapper.findEquipment(pagemap);
		return equipmentlist;
	}
	public void add1(Map<String, Object> xinximap) {
		// TODO Auto-generated method stub
		equipmentMapper.add1(xinximap);
	}
	public void del(int id) {
		// TODO Auto-generated method stub
		equipmentMapper.del(id);
	}

	@Override
	public List<Map<String, Object>> selectNames(Map<String, Object> modelName) {
		List<Map<String, Object>> nameList = equipmentMapper.selectName(modelName);
		return nameList;
	}

	@Override
	public List<Map<String, Object>> selectModelNumbers(Map<String, Object> modelNumber , String name) {
		List<Map<String, Object>> modelNumberList = equipmentMapper.selectModelNumber(modelNumber,name);
		return modelNumberList;
	}

	@Override
	public List<Map<String, Object>> selectModelNameAndNumbers(Map<String, Object> modelNameAndNumber, String name, String model_Number) {
		List<Map<String , Object>> modelNameAndNumberList = equipmentMapper.selectModelNameAndNumber(modelNameAndNumber,name,model_Number);
		return modelNameAndNumberList;
	}
}
