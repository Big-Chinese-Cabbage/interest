package com.interest.controller.article;

import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public ResponseWrapper<String> createArticle(@RequestBody ArticleCreateRequest articleCreateRequest){
        articleService.createArticle(articleCreateRequest);
        return new ResponseWrapper<>("发布成功");
    }

}
