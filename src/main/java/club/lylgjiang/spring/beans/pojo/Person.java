package club.lylgjiang.spring.beans.pojo;

import club.lylgjiang.spring.beans.pojo.Car;

/**
 * @Classname Person
 * @Description 个体(类)
 * @Date 2019/9/18 21:21
 * @Created by Jiavg
 */
public class Person {
    
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private String sax;
    // 工资
    private Double salary;
    // 汽车
    private Car car;
    // 社会阶级: car.price>300000 ? "金领":"白领"
    private String socialStratum;

    public Person() {
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Person(String name, String sax, Integer age) {
        this.name = name;
        this.age = age;
        this.sax = sax;
    }

    public Person(String name, String sax, Double salary) {
        this.name = name;
        this.sax = sax;
        this.salary = salary;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setSax(String sax) {
        this.sax = sax;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public void setSocialStratum(String socialStratum) {
        this.socialStratum = socialStratum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sax='" + sax + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                ", socialStratum='" + socialStratum + '\'' +
                '}';
    }
}
