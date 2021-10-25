package com.sherlockmen.blog.web;

import com.sherlockmen.blog.po.Tag;
import com.sherlockmen.blog.po.Type;
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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;
    @GetMapping("/targs/{id}")
    public String targs(@PageableDefault(size = 3, sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id, Model model){

        List<Tag> tags = tagService.listTopTag(100000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        model.addAttribute("newblogs", blogService.listBlogTop(3));
        return "targs";
    }
}
