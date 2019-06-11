package com.lingyi.app.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingyi.app.bean.Student;
import com.lingyi.app.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 鍓嶇鎺у埗鍣�
 * </p>
 *
 * @author liu
 * @since 2019-05-06
 */
@RestController
@RequestMapping("/student")
@Api("这是学生控制器类")
public class StudentController {
	@Autowired
	private StudentService sse;

	@RequestMapping("/save")
	@ApiOperation("这是添加的方法,返回一个结果")
	public boolean save(Student student) {
		return sse.save(student);
	}

	@RequestMapping("/listPage")
	@ApiOperation("这是分页查询的方法,返回一个结果集,传递了三个参数")
	public HashMap<String, Object> listPage(Integer page, Integer limit, String name) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page - 1) * limit);
		map.put("rows", limit);
		map.put("name", name);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("data", sse.listPage(map));
		result.put("count", sse.count(null));
		result.put("code", 0);
		result.put("msg", "");
		return result;

	}

	@RequestMapping("/remove/{id}")
	@ApiOperation("这是根据ID删除一条记录的方法,返回一个结果,传递了一个参数")
	public boolean remove(@PathVariable("id")Integer id) {
		return sse.removeById(id);
	}

	@RequestMapping("/removeBatch")
	@ApiOperation("这是批量删除的方法,返回一个结果")
	public boolean removeBatch(@RequestParam("ids[]") Collection<? extends Serializable> ids) {
		return sse.removeByIds(ids);
	}

	@RequestMapping("/update")
	@ApiOperation("这是修改的方法,返回一个结果")
	public boolean updateById(Student student) {
		return sse.updateById(student);
	}

}
