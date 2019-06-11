package com.lingyi.app.service.impl;

import com.lingyi.app.bean.Emp;
import com.lingyi.app.mapper.EmpMapper;
import com.lingyi.app.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu
 * @since 2019-05-17
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
