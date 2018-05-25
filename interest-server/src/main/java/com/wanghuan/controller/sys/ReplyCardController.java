package com.wanghuan.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wanghuan.model.sys.PageResult;
import com.wanghuan.model.sys.ReplyCardEntity;
import com.wanghuan.service.sys.ReplyCardService;

@RestController
public class ReplyCardController {

	@Autowired
	private ReplyCardService replyCardService;

	@GetMapping("/replycards")
	public PageResult replycardList(@RequestParam("postcardid") int postcardid,
			@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(replyCardService.replycardList(postcardid, pageSize, page * pageSize));
		pageResult.setTotalCount(replyCardService.replycardSize(postcardid, pageSize, page * pageSize));
		return pageResult;
	}
	
//	@GetMapping("/replycards/replycard")
//	public ReplyCardEntity preplyardGet(@RequestParam("id") int id) {
//		return replyCardService.getReplycard(id);
//	}
//	
	@PostMapping("/replycards/replycard")
	public ReplyCardEntity insertEntity(@RequestBody ReplyCardEntity replyCardEntity ) {
		replyCardService.insertEntity(replyCardEntity);
		return replyCardEntity;
	}

}
