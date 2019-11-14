package com.yyh.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyh.po.Emp;
import com.yyh.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-14-11:21
 */
@Controller
public class PageHandler {
    @Resource
    EmpService ss;

    @RequestMapping("/find")
    public String page(Model model, Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        //3.1  PageHelper.statPage
        PageHelper.startPage(pageNum, 2);
        //3.2正常查询
        List<Emp> list = ss.selectAll();
        //3.3分页
        PageInfo<Emp> info = new PageInfo<Emp>(list);
        //获取总页数
        int pages = info.getPages();
        List<Integer> page = new ArrayList<Integer>();
        for (int i = 1; i <= pages; i++) {
            page.add(i);
        }
        //1.传递分页后的数据
        model.addAttribute("list", info.getList());
        //2.传递当前页码
        model.addAttribute("pageNum", pageNum);
        //3.传递总页数
        model.addAttribute("sumPage", pages);
        //4.传递页码集合
        model.addAttribute("page",page);
        return "index";
    }


}
