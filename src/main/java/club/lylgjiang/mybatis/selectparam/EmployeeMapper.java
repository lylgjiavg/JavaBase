package club.lylgjiang.mybatis.selectparam;

import club.lylgjiang.mybatis.pojo.Employee;

/**
 * @Classname EmployeeMapper
 * @Description 雇员持久层
 * @Date 2019/9/27 13:43
 * @Created by Jiavg
 */
public interface EmployeeMapper {
    
    public Employee getEmpById(Integer id);
    
    public Employee getEmpByIdMap(Integer id);
    
    public Employee getEmpAndDeptById(Integer id);
    
    public Employee getEmpAndDeptByIdPlus(Integer id);
    
    public Employee getEmpAndDeptByIdPlusStep(Integer id);
    
}
