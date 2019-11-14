package com.yyh.po;

import lombok.Data;

/**
 * @author YanYuHang
 * @create 2019-11-14-10:03
 */
@Data
public class Emp {
    private int id;
    private String name;
    private int age;
    private String sex;
    private Dept deptid;
}
