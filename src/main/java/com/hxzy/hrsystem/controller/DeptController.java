package com.hxzy.hrsystem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hxzy.hrsystem.entity.Dept;
import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.service.DeptService;
import com.hxzy.hrsystem.util.JsonData;

@Controller
public class DeptController {

	private DeptService deptService;

	@Resource(name = "deptServiceImpl")
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/depts", method = RequestMethod.GET)
	public ModelAndView getDepts(@RequestParam(value = "pn", defaultValue = "1") Integer pn, ModelAndView mav) {
		int zys = deptService.getTotalPages(5);// 得到总页数
		if (null != pn && !"".equals(pn)) {
			if (pn > zys) {// 如果传过来页数大于总页数，就显示最后一页
				pn = zys;
			} else if (pn <= 0) {// 如果传过来页数小于0，就显示第一页
				pn = 1;
			}
		}
		PageInfo pageInfo = deptService.getPageInfo(pn);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName("admin/dept");
		return mav;
	}
	
	/**获取全部部门信息*/
	@RequestMapping(value = "/depts/json", method = RequestMethod.GET)
	@ResponseBody
	public JsonData getDeptsJson() {
		List<Dept> depts = null;
		try {
			depts = deptService.findDeptAll();
			for (Dept dept : depts) {
				System.out.println("***********************::"+dept.getDeptName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail("获取数据失败");
		}
		
		
		return JsonData.success(depts);
	}
	
	/** 获取当个部门*/
	@RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JsonData deptInfo(@PathVariable(name = "id", required = true) int id) {
		System.out.println("id:" + id);
		Dept dept = deptService.getDeptById(id);
		
		// 前端出现$ref解决办法 ，暂时不可取，会导致 java.lang.StackOverflowError
		//String jsonStr=JSON.toJSONString(depts, SerializerFeature.DisableCircularReferenceDetect); 
		if(null!=dept.getParent()) {//有上级部门
			int parentId = dept.getParent().getDeptId();
			return JsonData.success(dept).add("parentId", parentId);
		}
		return JsonData.success(dept);//没有上级部门不返回上级部门id
	}

	@RequestMapping(value = "/dept/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonData deleteDept(@PathVariable(name = "id", required = true) int id) {
		try {
			deptService.deleteDeptById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail();
		}
		return JsonData.success();
	}

	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	@ResponseBody
	public JsonData addDept(Integer parentId, Dept dept) {
		if (null != dept.getDeptName()) {
			System.out.println("ID:"+parentId);
			if(null!=parentId) {
				System.out.println("不为NULL");
				Dept dept2 = deptService.getDeptById(parentId);
				dept.setParent(dept2);
				deptService.addDept(dept);// 添加数据
			}else {
				deptService.addDept(dept);// 添加数据
			}
			
			int zys = deptService.getTotalPages(5);// 得到总页数
			return JsonData.success(zys);// 返回处理结果
		}
		return JsonData.fail();

	}

	@RequestMapping(value = "/dept/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonData updateDept(@ModelAttribute Dept dept) {

		if (null != dept.getDeptId()) {
			Dept dept2 = deptService.getDeptById(dept.getDeptId());
			dept2.setDeptName(dept.getDeptName());
			dept2.setDescription(dept.getDescription());
			deptService.updateDept(dept2);
			return JsonData.success();
		}
		return JsonData.fail();
	}

	/**
	 * 检查部门名是否重复
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/checkdeptname")
	public @ResponseBody JsonData checkDeptName(@RequestParam("deptName") String deptName) {
		if (deptService.checkDeptName(deptName)) {
			return JsonData.successSendMsg("部门名可用");
		} else {
			return JsonData.fail("部门名不可用");
		}
	}

}
