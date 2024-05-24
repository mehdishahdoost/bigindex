package com.github.mehdishahdoost.repository;

import com.github.mehdishahdoost.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
