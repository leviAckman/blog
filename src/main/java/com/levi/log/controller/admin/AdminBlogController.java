package com.levi.log.controller.admin;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Tag;
import com.levi.log.pojo.Type;
import com.levi.log.service.BlogService;
import com.levi.log.service.TagService;
import com.levi.log.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBlogController {
    @Autowired
    TagService tagService;
    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;
    //博客管理页面
    @GetMapping("/blogs")
    public String blogs(@RequestParam(name="pagenum",defaultValue = "1") Integer pageNum, Model model){
        PageInfo<Blog> blogPageInfo = blogService.listBlog(pageNum, 6);
        model.addAttribute("pageInfo",blogPageInfo);
        return "admin/blogs";
    }
    //更新页面
    @GetMapping("/blogs/update")
    public String updateBlogPage(@RequestParam("blogid")String blogId,Model model){
        model.addAttribute("tags",tagService.listTag());
        model.addAttribute("types",typeService.listType());
        //拿到博客
        Blog blog=blogService.getBlog(blogId);
        blog.initTagIdsStr();
        model.addAttribute("blog",blog);
        return "admin/blogs-update";
    }
    //博客编写页面
    @GetMapping("/blogs/input")
    public String blogsInput(Model model){
        List<Tag> tags = tagService.listTag();
        List<Type> types = typeService.listType();
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        return "admin/blogs-input";
    }
    //添加一个博客
    @PostMapping("/blogs/save")
    public String saveBlog(Blog blog,Integer typeId,int[] tagId){
        blogService.addBlog(blog,typeId,tagId);
        return "redirect:/admin/blogs";
    }
    //修改一个博客
    @PostMapping("/blogs/update")
    public String updateBlog(Blog blog,Integer typeId,int[] tagId){
        blogService.updateBlog(blog,typeId,tagId);
        return "redirect:/admin/blogs";
    }
    //删除一个博客
    @GetMapping("/blogs/delete")
    public String deleteBlog(@RequestParam(name="blogid") String blogId){
        blogService.deleteBlog(blogId);
        return "redirect:/admin/blogs";
    }
}
