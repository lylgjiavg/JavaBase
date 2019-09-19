package club.lylgjiang.spring.beans.pojo;

/**
 * @Classname Company
 * @Description 公司类
 * @Date 2019/9/19 9:52
 * @Created by Jiavg
 */
public class Company {
    
    // 公司名称
    private String name;
    // 公司法定代表人
    private Person legalPerson;
    // 公司专车
    private Car car;;

    public void setName(String name) {
        this.name = name;
    }

    public void setLegalPerson(Person legalPerson) {
        this.legalPerson = legalPerson;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", legalPerson=" + legalPerson +
                ", car=" + car +
                '}';
    }
}
