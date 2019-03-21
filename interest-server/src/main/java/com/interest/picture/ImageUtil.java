package com.interest.picture;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.UUID;

public class ImageUtil {

    /**
     * 保存文件，直接以multipartFile形式(不压缩)
     *
     * @param multipartFile
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile, String path) throws IOException {
        String pictureFormat = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID().toString() + "." + pictureFormat;
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
     * 保存文件，压缩成jpeg格式
     *
     * @param multipartFile
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImgAndJPEGEncode(MultipartFile multipartFile, String path) throws IOException {
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        Image image = ImageIO.read(fileInputStream);

        return imageJPEGEncode(image, path);
    }


    /**
     * 链接url保存图片
     *
     * @param urlForString
     * @param path
     * @return
     * @throws IOException
     */
    public static String saveImg(String urlForString, String path) throws IOException {
        String pictureFormat = urlForString.substring(urlForString.lastIndexOf(".") + 1);

        return saveImg(urlForString, path, pictureFormat);
    }

    /**
     * 链接url保存图片
     *
     * @param urlForString  连接url
     * @param path          存储路径
     * @param pictureFormat 图片后缀
     * @return
     * @throws IOException
     */
    public static String saveImg(String urlForString, String path, String pictureFormat) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        URL url = new URL(urlForString);

        DataInputStream dataInputStream = new DataInputStream(url.openStream());
        String fileName = UUID.randomUUID().toString() + "." + pictureFormat;
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

    public static void imgJPEGEncode(String url, String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            // 开始读取文件
            Image image = ImageIO.read(new URL(url));

            // 获取原始图片宽高
            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);

            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

            // 这边是压缩的模式设置
            tag.getGraphics().drawImage(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH), 0, 0, null);

            //创建文件输出流
            String fileName = UUID.randomUUID().toString() + ".jpeg";
            FileOutputStream out = new FileOutputStream(path + File.separator + fileName);
            //将图片按JPEG压缩，保存到out中
            ImageIO.write(tag, "JPEG", out);

            //关闭文件输出流
            out.close();
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }

    /**
     * 压缩图片（jpeg格式）
     *
     * @param image 需要压缩的图片Image格式
     * @param path  存储路径
     * @return
     * @throws IOException
     */
    public static String imageJPEGEncode(Image image, String path) throws IOException {

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 获取原始图片宽高
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        // 构造一个类型为预定义图像类型之一的 BufferedImage
        BufferedImage tag = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        // 这边是压缩的模式设置
        tag.getGraphics().drawImage(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH), 0, 0, null);

        //创建文件输出流
        String fileName = UUID.randomUUID().toString() + ".jpeg";
        FileOutputStream out = new FileOutputStream(path + File.separator + fileName);
        //将图片按JPEG压缩，保存到out中
        ImageIO.write(tag, "JPEG", out);
        //关闭文件输出流
        out.close();

        return fileName;
    }

    public static void reduceImg(String imgsrc, String imgdist) {
        try {
            File srcfile = new File(imgsrc);
            // 检查图片文件是否存在
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
            }
            int[] results = getImgWidthHeight(srcfile);

            int widthdist = results[0];
            int heightdist = results[1];
            // 开始读取文件并进行压缩
            Image src = ImageIO.read(srcfile);

            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage(widthdist, heightdist, BufferedImage.TYPE_INT_RGB);

            // 这边是压缩的模式设置
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);

            //创建文件输出流
            FileOutputStream out = new FileOutputStream(imgdist);
            //将图片按JPEG压缩，保存到out中
            ImageIO.write(tag, "JPEG", out);
            //关闭文件输出流
            out.close();
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }

    /**
     * 获取图片宽度和高度
     *
     * @param file 图片路径
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = {0, 0};
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            // 得到源图片宽
            result[0] = src.getWidth(null);
            // 得到源图片高
            result[1] = src.getHeight(null);
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }

    /**
     * 删除本地图片
     * @param fileName 文件全路径名
     * @return
     */
    public static boolean deleteImage(String fileName){
        File file =new File(fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }

}
