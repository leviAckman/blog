package com.levi.log.controller.admin;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Tag;
import com.levi.log.pojo.Type;
import com.levi.log.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminTagController {
    @Autowired
    TagService ts;

    //类型管理页面
    @GetMapping("/tags")
    public String tags(@RequestParam(name = "pagenum",defaultValue = "1")int pageNum,
                        Model model, String message){
        PageInfo<Tag> pageInfo = ts.listTagPag(pageNum, 6);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("message",message);
        return "admin/tags";
    }

    //类型编写页面
    @GetMapping("/tags/input")
    public String tagsInput(String message,Model model){
        model.addAttribute("message",message);
        return "admin/tags-input";
    }

    //类型修改页面
    @GetMapping("/tags/update")
    public String tagUpdatePage(@RequestParam("tagid")Integer tagId,@RequestParam("pagenum")Integer pageNum,
                                 Model model){
        Tag tag = ts.getTag(tagId);
        model.addAttribute("tag",tag);
        model.addAttribute("pagenum",pageNum);
        return "admin/tags-update";
    }

    //添加
    @PostMapping("/tags/save")
    public String saveTag(@RequestParam(name = "tagname")String tagName,
                           RedirectAttributes redirectAttributes){
        //ts.getTypeName(typeName)!=null为null时，ts.saveType(typeName)不会执行,即不会执行保存方法
        if(ts.getTagName(tagName)==null && ts.saveTag(tagName)){
            redirectAttributes.addAttribute("message","恭喜！添加成功");
        }else{
            redirectAttributes.addAttribute("message","<p style='color: red'>抱歉！添加失败</p>");
        }
        return "redirect:/admin/tags/input";
    }

    //删除
    @GetMapping("/tags/delete")
    public String deleteTag(@RequestParam("tagid")Integer tagId,@RequestParam("pagenum")Integer pageNum,
                             RedirectAttributes redirectAttributes){
        if(ts.deleteTag(tagId)){
            redirectAttributes.addAttribute("message","恭喜！删除成功");
        }else{
            redirectAttributes.addAttribute("message","<p style='color: red'>抱歉！删除失败</p>");
        }
        redirectAttributes.addAttribute("pagenum",pageNum);
        return "redirect:/admin/tags";
    }
    //修改
    @PostMapping("/tags/update")
    public String upadteTag(Tag tag,@RequestParam("pagenum")Integer pageNum,
                             RedirectAttributes redirectAttributes){
        if(tag!=null && ts.getTagName(tag.getTagName())==null && ts.updateTag(tag)){
            redirectAttributes.addAttribute("message","恭喜！修改成功");
        }else{
            redirectAttributes.addAttribute("message","<p style='color: red'>抱歉！修改失败</p>");
        }
        redirectAttributes.addAttribute("pagenum",pageNum);
        return "redirect:/admin/tags";
    }
}
