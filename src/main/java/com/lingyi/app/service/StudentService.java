package com.lingyi.app.service;

import com.lingyi.app.bean.Student;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liu
 * @since 2019-05-06
 */
public interface StudentService extends IService<Student> {

	List<Student> listPage(HashMap<String, Object> map);
	

}
