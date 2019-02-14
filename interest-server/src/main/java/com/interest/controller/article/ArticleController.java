package com.interest.controller.article;

import com.interest.model.entity.PageResult;
import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.response.ArticleResponse;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public ResponseWrapper<String> createArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
        articleService.createArticle(articleCreateRequest);
        return new ResponseWrapper<>("发布成功");
    }

    @GetMapping("/public/articles")
    public ResponseWrapper<PageResult> getArticle(@RequestParam(value = "searchContent", required = false) String searchContent,
                                                   @RequestParam("pageSize") int pageSize,
                                                   @RequestParam("page") int page) {
        PageWrapper pageWrapper = new PageWrapper(pageSize,page);
        PageResult pageResult = articleService.getArticle(searchContent,pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

    @GetMapping("/public/articles/article/{id}")
    public ResponseWrapper<ArticleDetailResponse> getArticleById(@PathVariable("id") int id) {
        ArticleDetailResponse articleDetailResponse = articleService.getArticleById(id);
        return new ResponseWrapper<>(articleDetailResponse);
    }

}
