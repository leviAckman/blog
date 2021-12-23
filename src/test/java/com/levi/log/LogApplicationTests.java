package com.levi.log;

import com.levi.log.dao.CommentDaoMapper;
import com.levi.log.dao.TypeDaoMapper;
import com.levi.log.pojo.Comment;
import com.levi.log.pojo.Type;
import com.levi.log.pojo.User;
import com.levi.log.service.TypeService;
import com.levi.log.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LogApplicationTests {

    @Autowired
    CommentDaoMapper us;

    @Autowired
    TypeDaoMapper ts;

    @Test
    void contextLoads() {
        List<Comment> comments = us.listCommentByBlogId("8948c9a8a2714c9c8b987e5b5e202ac7");
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }
}
