package com.levi.log.controller.admin;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Type;
import com.levi.log.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminTypeController {
    @Autowired
    TypeService ts;

    //类型管理页面
    @GetMapping("/types")
    public String types(@RequestParam(name = "pagenum",defaultValue = "1")int pageNum,
                        Model model,String message){
        PageInfo<Type> pageInfo = ts.listTypePag(pageNum, 6);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("message",message);
        return "admin/types";
    }

    //类型编写页面
    @GetMapping("/types/input")
    public String typesInput(String message,Model model){
        model.addAttribute("message",message);
        return "admin/types-input";
    }

    //类型修改页面
    @GetMapping("/types/update")
    public String typeUpdatePage(@RequestParam("typeid")Integer typeId,@RequestParam("pagenum")Integer pageNum,
                                 Model model){
        Type type = ts.getType(typeId);
        model.addAttribute("type",type);
        model.addAttribute("pagenum",pageNum);
        return "admin/types-update";
    }

    //添加
    @PostMapping("/types/save")
    public String saveType(@RequestParam(name = "typename")String typeName,
                           RedirectAttributes redirectAttributes){
        //ts.getTypeName(typeName)!=null为null时，ts.saveType(typeName)不会执行,即不会执行保存方法
        if(ts.getTypeName(typeName)==null && ts.saveType(typeName)){
            redirectAttributes.addAttribute("message","恭喜！添加成功");
        }else{
            redirectAttributes.addAttribute("message","<p style='color: red'>抱歉！添加失败</p>");
        }
        return "redirect:/admin/types/input";
    }

    //删除
    @GetMapping("/types/delete")
    public String deleteType(@RequestParam("typeid")Integer typeId,@RequestParam("pagenum")Integer pageNum,
                             RedirectAttributes redirectAttributes){
        if(ts.deleteType(typeId)){
            redirectAttributes.addAttribute("message","恭喜！删除成功");
        }else{
            redirectAttributes.addAttribute("message","<p style='color: red'>抱歉！删除失败</p>");
        }
        redirectAttributes.addAttribute("pagenum",pageNum);
        return "redirect:/admin/types";
    }
    //修改
    @PostMapping("/types/update")
    public String upadteType(Type type,@RequestParam("pagenum")Integer pageNum,
                             RedirectAttributes redirectAttributes){
        if(type!=null && ts.getTypeName(type.getTypeName())==null && ts.updateType(type)){
            redirectAttributes.addAttribute("message","恭喜！修改成功");
        }else{
            redirectAttributes.addAttribute("message","<p style='color: red'>抱歉！修改失败</p>");
        }
        redirectAttributes.addAttribute("pagenum",pageNum);
        return "redirect:/admin/types";
    }
}
