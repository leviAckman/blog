package com.levi.log.controller.view;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Tag;
import com.levi.log.pojo.Type;
import com.levi.log.service.BlogService;
import com.levi.log.service.TagService;
import com.levi.log.service.TypeService;
import com.levi.log.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ViewIndexController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    @GetMapping({"/","/index.html","/blogs"})
    public String index(@RequestParam(name="pagenum",defaultValue = "1")int pageNum,
                        Model model){
        //拿到博客
        PageInfo<Blog> blogPageInfo = blogService.listBlogView(pageNum, 8);
        //最新推荐
        List<Blog> blogRecomments = blogService.ListBlogRecomment();
        //拿到标签
        List<Tag> tags = tagService.listTagView();
        //拿到类型
        List<Type> types = typeService.listTypeView();

        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("blogRecomments",blogRecomments);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "index";
    }
}
