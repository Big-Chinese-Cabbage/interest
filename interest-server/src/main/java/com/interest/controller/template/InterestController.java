package com.interest.controller.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interest.model.InterestEntity;
import com.interest.model.PageResult;
import com.interest.model.utils.ResponseWrapper;
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
    public ResponseWrapper<List<InterestEntity>> insterestGet(@RequestParam(value = "title", required = false) String title) {
        return new ResponseWrapper<>(interestService.getInsterest(title));
    }

    @GetMapping("/public/interests/interest")
    public ResponseWrapper<InterestEntity> insterestGetById(@RequestParam(value = "id") int id) {
        return new ResponseWrapper<>(interestService.getInsterestById(id));
    }

    @PostMapping("/admin/interest/upload/picture")
    public ResponseWrapper<Map<String, String>> uploadPicture(@RequestParam("picture") MultipartFile picture) {

        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("time", DateUtil.currentTimestamp());

        String pictureUrl = interestService.savePicture(picture);
        resultMap.put("url", pictureUrl);
        return new ResponseWrapper<>(resultMap);
    }

    @PostMapping("/admin/interests/interest")
    public ResponseWrapper<InterestEntity> interestInsert(@RequestBody InterestEntity interestEntity) {

        interestService.insertEntity(interestEntity);

        return new ResponseWrapper<>(interestEntity);
    }

    @PutMapping("/admin/interests/interest")
    public ResponseWrapper<InterestEntity> interestUpdate(@RequestBody InterestEntity interestEntity) {

        interestService.updateEntity(interestEntity);

        return new ResponseWrapper<>(interestEntity);
    }

    @GetMapping("/admin/interests")
    public ResponseWrapper<PageResult> interestList(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult pageResult = new PageResult();
        pageResult.setData(interestService.interestList(pageSize, page * pageSize));
        pageResult.setTotalCount(interestService.interestSize());
        return new ResponseWrapper<>(pageResult);
    }

    @DeleteMapping("/admin/interests")
    public ResponseWrapper<List<String>> deleteInterests(@RequestBody List<String> groupId) {
        interestService.deleteInterests(groupId);
        return new ResponseWrapper<>(groupId);
    }

    @GetMapping("/public/banners")
    public ResponseWrapper<List<InterestEntity>> bannersGet() {
        return new ResponseWrapper<>(interestService.getBanners());
    }

    @PutMapping("/admin/banners/set")
    public ResponseWrapper<List<String>> bannersSet(@RequestBody List<String> groupId) {
        interestService.updateBanners(groupId, 1);
        return new ResponseWrapper<>(groupId);
    }

    @PutMapping("/admin/banners/del")
    public ResponseWrapper<List<String>> bannersDel(@RequestBody List<String> groupId) {
        interestService.updateBanners(groupId, 0);
        return new ResponseWrapper<>(groupId);
    }

}
