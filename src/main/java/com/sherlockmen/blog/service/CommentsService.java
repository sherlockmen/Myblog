package com.sherlockmen.blog.service;

import com.sherlockmen.blog.po.Comment;

import java.util.List;

public interface CommentsService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

}
