package com.sherlockmen.blog.web;

import com.sherlockmen.blog.service.BlogService;
import com.sherlockmen.blog.service.TagService;
import com.sherlockmen.blog.service.TypeService;
import com.sherlockmen.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sherlockmen.blog.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController{

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTopTag(10));
        model.addAttribute("recommendBlogs", blogService.listBlogTop(8));
        model.addAttribute("newblogs", blogService.listBlogTop(3));
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        model.addAttribute("blog", blogService.getAndConvert(id));
        model.addAttribute("newblogs", blogService.listBlogTop(3));
        return "blog";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC)
                         Pageable pageable, @RequestParam String query, Model model){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query", query);
        model.addAttribute("newblogs", blogService.listBlogTop(3));
        return "search";
    }

//    @GetMapping("/footer/newblog")
//    public String newblogs(Model model){
//        model.addAttribute("newblogs",blogService.listBlogTop(3));
//        return "_fragments :: newblogList";
//    }

}
