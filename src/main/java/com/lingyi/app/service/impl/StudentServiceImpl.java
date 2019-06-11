package com.lingyi.app.service.impl;

import com.lingyi.app.bean.Student;
import com.lingyi.app.mapper.StudentMapper;
import com.lingyi.app.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu
 * @since 2019-05-06
 */
@Transactional
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
	
	@Autowired
	private StudentMapper sm;
	
	@Override
	public List<Student> listPage(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sm.listPage(map);
	}

	

}
