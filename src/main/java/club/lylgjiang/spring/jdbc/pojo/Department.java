package club.lylgjiang.spring.jdbc.pojo;

/**
 * @Classname Department
 * @Description 部门类
 * @Date 2019/9/21 7:16
 * @Created by Jiavg
 */
public class Department {
    // id
    private Integer id;
    // 部门名称
    private String name;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
