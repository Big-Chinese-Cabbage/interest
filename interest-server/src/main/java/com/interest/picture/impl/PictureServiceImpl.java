package com.interest.picture.impl;

import com.interest.picture.ImageUtil;
import com.interest.picture.PictureService;
import com.interest.properties.PathsProperties;
import com.interest.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PathsProperties pathsProperties;

    @Override
    public String saveImage(MultipartFile picture) {

        return saveImage(picture, "");
    }

    @Override
    public String saveImage(MultipartFile picture, String path) {
        path = "/interest" + path + "/" + DateUtil.currentTimes();

        String pictureUrl = null;
        try {
            if (picture != null) {
                String fileName = ImageUtil.saveImgAndJPEGEncode(picture, pathsProperties.getImage() + path);
                pictureUrl = pathsProperties.getDomainName() + "/interest" + path + "/" + fileName;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pictureUrl;
    }

    @Override
    public String saveImage(String url, String pictureFormat) {
        return saveImage(url, "", pictureFormat);
    }

    @Override
    public String saveImage(String url, String path, String pictureFormat) {
        path = "/interest" + path + "/" + DateUtil.currentTimes();

        String pictureUrl = null;
        try {
            String fileName = ImageUtil.saveImg(url, pathsProperties.getImage() + path, pictureFormat);
            pictureUrl = pathsProperties.getDomainName() + "/interest" + path + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pictureUrl;
    }

    @Override
    public boolean deleteImage(String pictureUrl) {
        String fileName = pathsProperties.getImage()+pictureUrl.substring(pictureUrl.lastIndexOf("/interest"));
        return ImageUtil.deleteImage(fileName);
    }
}
