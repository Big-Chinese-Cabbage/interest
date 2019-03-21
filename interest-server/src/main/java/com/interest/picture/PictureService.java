package com.interest.picture;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    String saveImage(MultipartFile picture);

    String saveImage(MultipartFile picture,String path);

    String saveImage(String url, String pictureFormat);

    String saveImage(String url,String path,String pictureFormat);

    boolean deleteImage(String pictureUrl);
}
