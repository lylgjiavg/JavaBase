package club.lylgjiang.mybatis.paramtransmit;

import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Classname EmployeeMapper
 * @Description 雇员持久层
 * @Date 2019/9/25 21:06
 * @Created by Jiavg
 */
public interface EmployeeMapper {
    
    public Employee selectById(Integer id);
    
    public Employee selectByIdAndName(Integer id, String lastName);
    
    public Employee selectByIdAndNameAnno(@Param("id") Integer id,@Param("lastName") String lastName);
    
    public Employee selectByIdAndNameMap(Map map);
    
    public Employee selectByIdAndNameSetting(Integer id, String lastName);
    
    public Employee selectByIdAndNameSetTB(Integer id, String lastName, String tableName);
    
}
