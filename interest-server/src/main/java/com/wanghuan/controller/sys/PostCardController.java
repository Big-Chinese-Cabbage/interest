package com.wanghuan.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wanghuan.model.sys.PageResult;
import com.wanghuan.model.sys.PostCardEntity;
import com.wanghuan.service.sys.PostCardService;

@RestController
public class PostCardController {

	@Autowired
	private PostCardService postCardService;

	@GetMapping("/postcards")
	public PageResult postcardList(@RequestParam(value="interestid",required=false) String interestid,
			@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(postCardService.postcardList(interestid, pageSize, page * pageSize));
		pageResult.setTotalCount(postCardService.postcardSize(interestid, pageSize, page * pageSize));
		return pageResult;
	}
	
	@GetMapping("/postcards/postcard")
	public PostCardEntity postcardGet(@RequestParam("id") int id) {
		return postCardService.getPostcard(id);
	}
	
	@PostMapping("/postcards/postcard")
	public PostCardEntity insertEntity(@RequestBody PostCardEntity postCardEntity ) {
		postCardService.insertEntity(postCardEntity);
		return postCardEntity;
	}
	
	@DeleteMapping("/postcards")
	public List<String> deletePostcards(@RequestBody List<String> groupId) {
		postCardService.deletePostcards(groupId);
		return groupId;
	}

}
