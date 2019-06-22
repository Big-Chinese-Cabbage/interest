package com.interest.controller.article;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.request.ArticleCommentRequest;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.ArticleCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "文章评论模块")
public class ArticleCommentController {

    @Autowired
    private ArticleCommentService articleCommentService;

    @InterestLog
    @ApiOperation(value = "文章评论/回复评论")
    @PostMapping("/article/comment")
    public ResponseWrapper<String> articleComment(@RequestBody ArticleCommentRequest articleCommentRequest) {

        articleCommentService.putArticleCommentService(articleCommentRequest);

        return new ResponseWrapper<>("评论成功");
    }

    @InterestLog
    @ApiOperation("查询文章评论")
    @GetMapping("/public/article/comment")
    public ResponseWrapper<PageResult> getArticleComment(@RequestParam("articleId") int articleId,
                                                                           @RequestParam("pageSize") int pageSize,
                                                                           @RequestParam("page") int page) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = articleCommentService.getArticleCommentByArticleId(articleId, pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

}
