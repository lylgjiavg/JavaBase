package club.lylgjiang.mybatis.mapper;

import club.lylgjiang.mybatis.pojo.Employee;

/**
 * @Classname EmployeeMapper
 * @Description 雇员Mapper
 * @Date 2019/9/24 8:47
 * @Created by Jiavg
 */
public interface EmployeeMapper {
    
    public Employee selectById(int id);
    
}
