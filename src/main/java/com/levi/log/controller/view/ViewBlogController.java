package com.levi.log.controller.view;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Comment;
import com.levi.log.pojo.Tag;
import com.levi.log.pojo.Type;
import com.levi.log.service.BlogService;
import com.levi.log.service.CommentService;
import com.levi.log.service.TagService;
import com.levi.log.service.TypeService;
import com.levi.log.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewBlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    //博客详情
    @GetMapping("/blog/{blogId}")
    public String blog(@PathVariable("blogId")String blogId, Model model){
        Blog blog = blogService.getBlogView(blogId);
        /*markdown转html 转换格式*/
        blog.setBlogContent(MarkdownUtils.markdownToHtml(blog.getBlogContent()));
        //查询评论
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments",comments);
        model.addAttribute("blog",blog);
        return "blog";
    }
    //搜索
    @GetMapping("/blog/search")
    public String search(@RequestParam(name="pagenum",defaultValue = "1")int pageNum,@RequestParam("query")String query,Model model){

        //拿到博客
        PageInfo<Blog> blogPageInfo = blogService.listBlogQuery(pageNum,6,query);
        //最新推荐
        List<Blog> blogRecomments = blogService.ListBlogRecomment();
        //拿到标签
        List<Tag> tags = tagService.listTagView();
        //拿到类型
        List<Type> types = typeService.listTypeView();

        model.addAttribute("query",query);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("blogRecomments",blogRecomments);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "search";
    }

    //评论
    @PostMapping("/blog/comment")
    public String comment(Comment comment, HttpSession session){
        if(session.getAttribute("user") != null){
            comment.setCommentBlogger(true);
        }
        comment.setCommentCreateDate(new Date());
        comment.setCommentPhoto("comment1.png");
        System.out.println(comment);
        boolean b = commentService.addComment(comment);
        return "redirect:/blog/"+comment.getCommentBlogId();
    }

    //分类
    @GetMapping("/blog/type")
    public String blogTyep(@RequestParam(name="pagenum",defaultValue = "1") int pageNum,int typeId,
                           Model model){
        List<Type> types = typeService.listTypeViewType();
        if(typeId == -1){
            typeId=types.get(0).getTypeId();
        }
        PageInfo<Blog> blogPageInfo = blogService.listBlogTypeId(pageNum,6,typeId);

        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("types",types);
        model.addAttribute("activeTypeId",typeId);
        return "types";
    }
    //标签
    @GetMapping("/blog/tag")
    public String blogTag(@RequestParam(name="pagenum",defaultValue = "1") int pageNum,int tagId,
                           Model model){
        List<Tag> tags = tagService.listTagViewTag();
        if(tagId == -1){
            tagId=tags.get(0).getTagId();
        }
        PageInfo<Tag> blogPageInfo = blogService.listBlogTagId(pageNum,6,tagId);

        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("tags",tags);
        model.addAttribute("activeTagId",tagId);
        return "tags";
    }
    //归档
    @GetMapping("/blog/archives")
    public String archives(Model model){
        Map<String,List<Blog>> map=new HashMap();
        int total=0;
        //查询所有年份
        List<String> years = blogService.blogCreateYears();
        for (String year : years) {
            List<Blog> blogs = blogService.blogByYears(year);
            map.put(year,blogs);
            total+=blogs.size();
        }
        model.addAttribute("map",map);
        model.addAttribute("total",total);
        return "archives";
    }
    //关于我
    @GetMapping("/about")
    public String about(){

        return "about";
    }

}
