package com.interest.controller.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interest.model.InterestEntity;
import com.interest.model.PageResult;
import com.interest.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interest.service.InterestService;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class InterestController {

	@Autowired
	private InterestService interestService;

	@GetMapping("/public/interests")
	public List<InterestEntity> insterestGet(@RequestParam(value="title",required=false) String title){
		return interestService.getInsterest(title);
	}

	@GetMapping("/public/interests/interest")
	public InterestEntity insterestGetById(@RequestParam(value="id") int id){
		return interestService.getInsterestById(id);
	}

	@PostMapping("/admin/interest/upload/picture")
	public Map<String, String> uploadPicture( @RequestParam("picture") MultipartFile picture) {

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("time", DateUtil.currentTimestamp());

		String pictureUrl = interestService.savePicture(picture);
		resultMap.put("url", pictureUrl);
		return resultMap;
	}

	@PostMapping("/admin/interests/interest")
	public InterestEntity interestInsert(@RequestBody InterestEntity interestEntity){

		interestService.insertEntity(interestEntity);

		return interestEntity;
	}

	@PutMapping("/admin/interests/interest")
	public InterestEntity interestUpdate(@RequestBody InterestEntity interestEntity){

		interestService.updateEntity(interestEntity);

		return interestEntity;
	}

	@GetMapping("/admin/interests")
	public PageResult interestList(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(interestService.interestList( pageSize, page * pageSize));
		pageResult.setTotalCount(interestService.interestSize());
		return pageResult;
	}

	@DeleteMapping("/admin/interests")
	public List<String> deleteInterests(@RequestBody List<String> groupId) {
		interestService.deleteInterests(groupId);
		return groupId;
	}

	@GetMapping("/public/banners")
	public List<InterestEntity> bannersGet(){
		return interestService.getBanners();
	}

	@PutMapping("/admin/banners/set")
	public List<String> bannersSet(@RequestBody List<String> groupId) {
		interestService.updateBanners(groupId,1);
		return groupId;
	}

	@PutMapping("/admin/banners/del")
	public List<String> bannersDel(@RequestBody List<String> groupId) {
		interestService.updateBanners(groupId,0);
		return groupId;
	}

}
