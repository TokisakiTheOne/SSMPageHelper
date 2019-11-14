import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyh.dao.EmpDao;
import com.yyh.po.Emp;
import com.yyh.service.EmpService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-beans.xml", "classpath*:spring/spring-mvc.xml"})
public class Test {
    @Autowired
    EmpService es;

    @org.junit.Test
    public void test() {
        PageHelper.startPage(1, 3);
        List<Emp> emps = es.selectAll();
        /*
         * 1.添加mybatis分页插件的依赖
         *  <dependency>
         *    <groupId>com.github.pagehelper</groupId>
         *    <artifactId>pagehelper</artifactId>
         *    <version>****</version>
         *  </dependency>
         *2.在配置文件中配置  分页插件
         * 在  sqlsessionfactorybean中配置
         *  <property name="plugins">
         *      <array>
         *          <bean class="com.github.pagehelper.PageHelper">
         *              <property name="properties">
         *                    <value>dialect=mysql</value>
         *              </property>
         *           </bean>
         *      </array>
         *  </property>
         *3.1 PageHelper.startPage(当前页码,每页显示的条数)
         *3.2 正常执行查询操作
         *3.3 PageInfo<实体类> info = new PageInfo<实体类>(集合);
         *3.4 分页之后的数据  info.getlist();
         *
         * */
        PageInfo<Emp> info = new PageInfo<Emp>(emps);

        for (Emp emp : info.getList()) {
            System.out.println("emp = " + emp);
        }
    }
}
