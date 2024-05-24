package com.github.mehdishahdoost.service;

import com.github.mehdishahdoost.model.Article;
import com.github.mehdishahdoost.model.Comment;
import com.github.mehdishahdoost.repository.ArticleRepository;
import com.github.mehdishahdoost.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;



    public void postComment(Long articleId, String content) {
        Optional<Article> article = articleRepository.findById(articleId);
        if(!article.isPresent())
            throw new RuntimeException("article does not exist");
        Article article1 = article.get();
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setArticleId(articleId);
        commentRepository.save(comment);

        article1.setCommentCount(article1.getCommentCount() + 1);
        articleRepository.save(article1);

    }

}
