package com.sherlockmen.blog.web;

import com.sherlockmen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @Autowired
    private BlogService blogService;
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("newblogs",blogService.listBlogTop(3));
        return "about";
    }

}
