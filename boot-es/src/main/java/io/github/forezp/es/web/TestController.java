package io.github.forezp.es.web;

import io.github.forezp.es.entity.User;
import io.github.forezp.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserService userService;


    @GetMapping("/testInsert")
    public void testInsert() {
        User user = new User();
        user.setuId("1");
        user.setName("zhangsna");
        user.setAge(101);
        user.setAddress("广东省深圳市");
        userService.save(user);

        user.setuId("2");
        user.setName("lisi");
        user.setAge(32);
        user.setAddress("广东省深圳市");
        userService.save(user);

        user.setuId("3");
        user.setName("wangwu");
        user.setAge(34);
        user.setAddress("广东省深圳市");
        userService.save(user);

    }

    @GetMapping("/testDelete")
    public void testDelete() {
        User user = new User();
        user.setuId("1");
        userService.delete(user);
    }

    @GetMapping("/testGetAll")
    public void testGetAll() {
        Iterable<User> iterable = userService.getAll();
        iterable.forEach(e -> System.out.println(e.toString()));
    }

    @GetMapping("/testGetByName")
    public void testGetByName() {
        List<User> list = userService.getByName("lisi");
        System.out.println(list);
    }

    @GetMapping("/testPage")
    public void testPage() {
        Page<User> page = userService.pageQuery(0, 10, "wangwu");
        System.out.println(page.getTotalPages());
        System.out.println(page.getNumber());
        System.out.println(page.getContent());
    }
}
