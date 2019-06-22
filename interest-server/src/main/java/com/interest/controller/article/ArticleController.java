package com.interest.controller.article;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.request.ArticleUpdateRequest;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.picture.PictureService;
import com.interest.service.ArticleService;
import com.interest.utils.SecurityAuthenUtil;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PictureService pictureService;

    @InterestLog
    @PostMapping("/article")
    public ResponseWrapper<String> createArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
        articleService.createArticle(articleCreateRequest);
        return new ResponseWrapper<>("发布成功");
    }

    @InterestLog
    @PutMapping("/article")
    public ResponseWrapper<String> updateArticle(@RequestBody ArticleUpdateRequest articleCreateRequest) {
        articleService.updateArticle(articleCreateRequest);
        return new ResponseWrapper<>("发布成功");
    }

    @InterestLog
    @GetMapping("/public/articles")
    public ResponseWrapper<PageResult> getArticle(@RequestParam(value = "searchContent", required = false) String searchContent,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @RequestParam("page") int page) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = articleService.getArticle(searchContent, pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @GetMapping("/admin/articles")
    public ResponseWrapper<PageResult> getArticles(@RequestParam(value = "searchContent", required = false) String searchContent,
                                                   @RequestParam(value = "dateTimestamp", required = false) String dateTimestamp,
                                                   @RequestParam(value = "del", required = false) int del,
                                                   @RequestParam("pageSize") int pageSize,
                                                   @RequestParam("page") int page) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = articleService.getArticleOnManagement(searchContent, dateTimestamp, del, pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @DeleteMapping("/admin/articles")
    public ResponseWrapper delArticles(@RequestBody List<String> groupId) {
        articleService.updateArticlesDelByIds(groupId, 1);
        return new ResponseWrapper<>(groupId);
    }

    @InterestLog
    @DeleteMapping("/articles/article/{id}")
    public ResponseWrapper delArticleById(@PathVariable("id") int articleId) {
        articleService.updateArticlesDelById(articleId);
        return new ResponseWrapper<>(articleId);
    }

    @InterestLog
    @PatchMapping("/admin/articles")
    public ResponseWrapper republishArticles(@RequestBody List<String> groupId) {
        articleService.updateArticlesDelByIds(groupId, 0);
        return new ResponseWrapper<>(groupId);
    }

    @InterestLog
    @PatchMapping("/admin/articles/top")
    public ResponseWrapper changeArticlesTop(@RequestBody List<String> groupId, @RequestParam("top") int top) {
        articleService.updateArticlesTopByIds(groupId, top);
        return new ResponseWrapper<>(groupId);
    }

    @InterestLog
    @GetMapping("/public/users/user/{userId}/articles")
    public ResponseWrapper<PageResult> getArticle(@PathVariable("userId") int userId,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @RequestParam("page") int page) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = articleService.getArticlesByUserId(userId, pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @GetMapping("/general/users/user/articles")
    public ResponseWrapper<PageResult> getUserArticle(@RequestParam("pageSize") int pageSize,
                                                      @RequestParam("page") int page) {
        int userId = SecurityAuthenUtil.getId();
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = articleService.getArticlesByUserId(userId, pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @GetMapping("/public/articles/article/{id}")
    public ResponseWrapper<ArticleDetailResponse> getArticleById(@PathVariable("id") int id) {
        ArticleDetailResponse articleDetailResponse = articleService.getArticleById(id);
        return new ResponseWrapper<>(articleDetailResponse);
    }

    @InterestLog
    @PostMapping("/upload/picture")
    public ResponseWrapper<String> uploadPicture(@RequestParam("picture") MultipartFile picture) {

        String pictureUrl = pictureService.saveImage(picture);

        return new ResponseWrapper<>(pictureUrl);
    }

}
