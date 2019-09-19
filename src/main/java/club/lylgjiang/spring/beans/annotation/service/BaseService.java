package club.lylgjiang.spring.beans.annotation.service;

import club.lylgjiang.spring.beans.annotation.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname BaseService
 * @Description 泛型依赖注入:基类
 * @Date 2019/9/20 0:32
 * @Created by Jiavg
 */
public class BaseService<T> {
    
    @Autowired
    protected BaseRepository baseRepository;
    
}
