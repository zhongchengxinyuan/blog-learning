package com.zhongchengxinyuan.blog.test;

import com.zhongchengxinyuan.blog.enums.Gender;
import com.zhongchengxinyuan.blog.model.User;
import com.zhongchengxinyuan.blog.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws ParseException {
        User user = new User();
        user.setUsername("fanksy");
        user.setPassword("admin123");
        user.setBirthDate(new SimpleDateFormat("yyyyMMdd").parse("1990-01-02"));
        user.setAddress("北京市顺义区马坡地区中晟馨苑3号院8号楼1单元201");
        user.setGender(Gender.MALE);
        user.setCreateTime(new Date());
        user.setNickname("fanjun");
        user.setPhoneNumber("18500136595");
        if(userRepository.existsByUsername(user.getUsername())){
            return;
        }
        userRepository.save(user);
        User user1 = userRepository.findById(user.getId()).get();
        User user2 = userRepository.findByUsername(user.getUsername());

        assert user1.getUsername().equals(user2.getUsername())
                && user1.getPassword().equals(user2.getPassword());
    }
}
