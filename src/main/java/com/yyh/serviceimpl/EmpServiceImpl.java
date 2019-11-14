package com.yyh.serviceimpl;

import com.yyh.dao.EmpDao;
import com.yyh.po.Emp;
import com.yyh.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-14-11:01
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    EmpDao ed;

    @Override
    public List<Emp> selectAll() {
        return ed.selectAll();
    }
}
