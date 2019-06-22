package com.interest.controller.template;

import com.interest.annotation.InterestLog;
import com.interest.model.entity.ReplyCardEntity;
import com.interest.model.response.ReplyCardResponse;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.ReplyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyCardController {

    @Autowired
    private ReplyCardService replyCardService;

    @InterestLog
    @GetMapping("/public/replycards")
    public ResponseWrapper<PageResult> replycardList(@RequestParam("postcardid") int postcardid,
                                                     @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult<ReplyCardResponse> pageResult = new PageResult<>();
        pageResult.setData(replyCardService.replycardList(postcardid, pageSize, page * pageSize));
        pageResult.setTotalCount(replyCardService.replycardSize(postcardid, pageSize, page * pageSize));
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @PostMapping("/replycards/replycard")
    public ResponseWrapper<ReplyCardEntity> insertEntity(@RequestBody ReplyCardEntity replyCardEntity) {
        replyCardService.insertEntity(replyCardEntity);
        return new ResponseWrapper<>(replyCardEntity);
    }

}
