package com.sherlockmen.blog.service;

import com.sherlockmen.blog.po.Tag;
import com.sherlockmen.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTopTag(Integer size);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);

}
