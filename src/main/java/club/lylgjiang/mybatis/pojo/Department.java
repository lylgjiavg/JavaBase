package club.lylgjiang.mybatis.pojo;

import java.util.List;

/**
 * @Classname Department
 * @Description 部门类
 * @Date 2019/9/27 14:11
 * @Created by Jiavg
 */
public class Department {
    
    private Integer id;
    private String departmentName;
    private List<Employee> employees;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
