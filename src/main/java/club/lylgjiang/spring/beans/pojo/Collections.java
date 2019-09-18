package club.lylgjiang.spring.beans.pojo;

import club.lylgjiang.spring.beans.pojo.Car;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Classname Collections
 * @Description 各个集合类
 * @Date 2019/9/18 23:24
 * @Created by Jiavg
 */
public class Collections {

    private Set set;
    private List list;
    private Map<String, Car> map;
    private Properties properties;

    public void setSet(Set set) {
        this.set = set;
    }
    public void setList(List list) {
        this.list = list;
    }
    public void setMap(Map<String, Car> map) {
        this.map = map;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "set=" + set +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
