package com.lingyi.app.mapper;

import com.lingyi.app.bean.Student;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liu
 * @since 2019-05-06
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

	List<Student> listPage(HashMap<String, Object> map);
	boolean updateId(Student student);

}
