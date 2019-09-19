package club.lylgjiang.spring.beans.annotation.repository;

import club.lylgjiang.spring.beans.annotation.pojo.Cart;
import org.springframework.stereotype.Repository;

/**
 * @Classname CartRepository
 * @Description 泛型依赖注入
 * @Date 2019/9/20 0:35
 * @Created by Jiavg
 */
@Repository
public class CartRepository extends BaseRepository<Cart> {
}
