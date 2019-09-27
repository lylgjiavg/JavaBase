package club.lylgjiang.mybatis.selectparam;

import club.lylgjiang.mybatis.pojo.Department;

/**
 * @Classname DepartmentMapper
 * @Description 部门持久层
 * @Date 2019/9/27 20:58
 * @Created by Jiavg
 */
public interface DepartmentMapper {
    
    public Department getDeptById(Integer id);
    
    public Department getDeptByIdCol(Integer id);

    public Department getDeptByIdColStep(Integer id);
    
}
