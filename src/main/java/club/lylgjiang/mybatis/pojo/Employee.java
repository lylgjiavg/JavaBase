package club.lylgjiang.mybatis.pojo;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.TypeHandler;

/**
 * @Classname Employee
 * @Description 雇员类
 * @Date 2019/9/23 23:49
 * @Created by Jiavg
 */
@Alias("employee")
public class Employee {
    
    private Integer id;
    // 姓名
    private String lastName;
    // 性别
    private String gender;
    // 邮件地址
    private String email;
    // 部门
    private Department department;
    
    public Employee() {
    }

    public Employee(Integer id, String lastName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
//                ", department=" + department +
                '}';
    }
}
