package com.kewei.manager.controller.system;

import com.kewei.manager.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备管理控制层
 *
 * @author Administrator
 * @date 2019/5/29 0029
 **/
@Controller
@RequestMapping("equipment")
public class EquipmentController {
	@Autowired
	private EquipmentService equipment;
	  /**
     * 跳转到设备管理
     * @return
     */
    @RequestMapping("/equipmentManage")
    public String toPage() {
        return "/display/shebei";
    }

	/**
	 * 查找设备所有数据-分页
	 * @param page
	 * @param limit
	 * @param pagemap
	 * @return
	 */
    @RequestMapping("/findEquipment")
    @ResponseBody
    public Map<String,Object> findEquipment(int page,int limit,Map<String,Object> pagemap) {
    	pagemap.put("page",(page-1)*limit);
		pagemap.put("num",limit);
		List<Map<String,Object>> cnlist=equipment.findEquipment(pagemap);
		HashMap<String,Object> map=new HashMap<>();
		//获取数据库总数
		int count=equipment.getCncount();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data",cnlist);
		return map;
    }

	/**
	 * 添加数据
	 * @param name
	 * @param model_Number
	 * @param factory_Number
	 * @param standard_Number
	 * @param eq_time
	 * @param canshu
	 * @param custom_Number
	 * @param xinximap
	 * @return
	 */
    @RequestMapping("/addequip")
    @ResponseBody
    public int addequip(String name,String model_Number,String factory_Number,String standard_Number,String eq_time,String canshu,String custom_Number,Map<String,Object> xinximap){
		try {
			xinximap.put("name", name);
			xinximap.put("model_Number", model_Number);
			xinximap.put("factory_Number", factory_Number);
			xinximap.put("standard_Number", standard_Number);
			xinximap.put("eq_time", eq_time);
			xinximap.put("canshu", canshu);
			xinximap.put("custom_Number",custom_Number);
			equipment.add1(xinximap);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
    }

  //根据id查删除记录
  	@ResponseBody
  	@RequestMapping("/del")
  	public int del(HttpServletRequest req){
  		int id=Integer.valueOf(req.getParameter("id"));
  		try {
  			equipment.del(id);
  		} catch (Exception e) {
  			return 0;
  		}
  		return 1;
  	}

	/**
	 * 查找设备名
	 * @param modelName
	 * @return
	 */
  	@PostMapping("findName")
	@ResponseBody
  	public Map<String , Object> findName(Map<String , Object> modelName){
    	List<Map<String , Object>> nameList = equipment.selectNames(modelName);
    	Map<String , Object> map = new HashMap<>();
    	map.put("nameList",nameList);
    	return map;
	}

	/**
	 * 查找设备型号
	 * @param modelNumber
	 * @param name
	 * @return
	 */
	@PostMapping("findModelNumber")
	@ResponseBody
	public Map<String , Object> findModelNumber(Map<String , Object> modelNumber , String name){
		List<Map<String , Object>> modelNumberList = equipment.selectModelNumbers(modelNumber,name);
		Map<String , Object> map = new HashMap<>();
		map.put("modelNumberList",modelNumberList);
		map.put("name",name);
		return map;
	}

	/**
	 * 查找设备型号级设备名
	 * @param modelNameAndNumber
	 * @param name
	 * @param model_Number
	 * @return
	 */
	@PostMapping("selectModelNameAndNumber")
	@ResponseBody
	public Map<String , Object> selectModelNameAndNumber(Map<String , Object> modelNameAndNumber , String name , String model_Number){
    	List<Map<String , Object>> modelNameAndNumberList = equipment.selectModelNameAndNumbers(modelNameAndNumber,name,model_Number);
		Map<String , Object> map = new HashMap<>();
		map.put("modelNameAndNumberList",modelNameAndNumberList);
		map.put("name",name);
		map.put("model_Number",model_Number);
		return map;
	}
}
