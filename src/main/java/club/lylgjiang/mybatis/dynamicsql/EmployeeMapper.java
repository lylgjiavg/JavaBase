package club.lylgjiang.mybatis.dynamicsql;

import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname EmployeeMapper
 * @Description 雇员持久类
 * @Date 2019/9/28 16:39
 * @Created by Jiavg
 */
public interface EmployeeMapper {
    
    public List<Employee> getEmpByConductIf(Employee employee);
    
    public List<Employee> getEmpByConductWhere(Employee employee);
    
    public List<Employee> getEmpByConductChoose(Employee employee);
    
    public List<Employee> getEmpByConductTrim(Employee employee);
    
    public long insertEmpConductForeach(List<Employee> employees);
    
    public long updateEmpConductSet(Employee employee);
    
    public List<Employee> getEmpByLikeNameConductBind(@Param("lastName") String lastName);

    public Employee getEmpByConductInnerParam(Integer id);
    
}
