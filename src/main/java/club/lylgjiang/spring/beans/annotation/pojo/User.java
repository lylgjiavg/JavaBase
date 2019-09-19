package club.lylgjiang.spring.beans.annotation.pojo;

import org.springframework.stereotype.Component;

/**
 * @Classname User
 * @Description 用户类
 * @Date 2019/9/20 0:17
 * @Created by Jiavg
 */
@Component
public class User {
    
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
