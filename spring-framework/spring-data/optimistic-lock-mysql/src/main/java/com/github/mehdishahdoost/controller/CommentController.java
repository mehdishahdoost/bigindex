package com.github.mehdishahdoost.controller;

import com.github.mehdishahdoost.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("comment")
    public String saveComment(@RequestBody CommentRequest commentRequest) {
        try {
            commentService.postComment(commentRequest.getArticleId(), commentRequest.getContent());

        } catch (Exception exception) {
            log.error(exception.getMessage());
            return "error" + exception.getMessage();
        }
        return "success";
    }

}
