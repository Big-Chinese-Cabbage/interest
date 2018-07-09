package com.interest.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.UUID;

public class ImageUtil {

	/**
	 * 保存文件，直接以multipartFile形式
	 * 
	 * @param multipartFile
	 * @param path
	 *            文件保存绝对路径
	 * @return 返回文件名
	 * @throws IOException
	 */
	public static String saveImg(MultipartFile multipartFile, String path) throws IOException {
		String pictureFormat = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
		String fileName = UUID.randomUUID().toString() + "."+pictureFormat;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
		byte[] bs = new byte[1024];
		int len;
		while ((len = fileInputStream.read(bs)) != -1) {
			bos.write(bs, 0, len);
		}
		bos.flush();
		bos.close();
		return fileName;
	}

	/**
	 * 链接url保存图片
	 * @param urlForString
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String saveImg(String urlForString, String path) throws IOException {

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}

		URL url = new URL(urlForString);
		DataInputStream dataInputStream = new DataInputStream(url.openStream());
		/* FileInputStream fileInputStream = (FileInputStream) url.openStream(); */
		String fileName = UUID.randomUUID().toString() + ".png";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));

		byte[] bs = new byte[1024];
		int len;
		while ((len = dataInputStream.read(bs)) != -1) {
			bos.write(bs, 0, len);
		}
		bos.flush();
		bos.close();

		return fileName;
	}

}
