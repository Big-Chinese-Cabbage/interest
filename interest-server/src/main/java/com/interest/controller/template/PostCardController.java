package com.interest.controller.template;

import com.interest.annotation.InterestLog;
import com.interest.model.entity.PostCardEntity;
import com.interest.model.response.PostCardResponse;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.PostCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostCardController {

    @Autowired
    private PostCardService postCardService;

    @InterestLog
    @GetMapping("/public/postcards")
    public ResponseWrapper<PageResult> postcardList(@RequestParam(value = "interestid", required = false) String interestid,
                                                    @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult<PostCardResponse> pageResult = new PageResult<>();
        pageResult.setData(postCardService.postcardList(interestid, pageSize, page * pageSize));
        pageResult.setTotalCount(postCardService.postcardSize(interestid, pageSize, page * pageSize));
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @GetMapping("/public/postcards/postcard")
    public ResponseWrapper<PostCardResponse> postcardGet(@RequestParam("id") int id) {
        return new ResponseWrapper<>(postCardService.getPostcard(id));
    }

    @InterestLog
    @PostMapping("/postcards/postcard")
    public ResponseWrapper<PostCardEntity> insertEntity(@RequestBody PostCardEntity postCardEntity) {
        postCardService.insertEntity(postCardEntity);
        return new ResponseWrapper<>(postCardEntity);
    }

    @InterestLog
    @DeleteMapping("/postcards")
    public ResponseWrapper<List<String>> deletePostcards(@RequestBody List<String> groupId) {
        postCardService.deletePostcards(groupId);
        return new ResponseWrapper<>(groupId);
    }

}
