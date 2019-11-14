package com.yyh.dao;

import com.yyh.po.Emp;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-14-10:04
 */
public interface EmpDao {

    List<Emp> selectAll();
}
