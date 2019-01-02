package com.ald.news.user.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 图片上传工具类
 *
 * @author xuxm
 */
public class FileUploadUtil {

    /**
     * 处理图片上传
     *
     * @param file     上传图片
     * @param basePath 存放文件目录的绝对路径 servletContext.getRealPath("/upload")
     * @return 文件存储路径名
     */
    public static String upload(MultipartFile file, String basePath) {
        // 生成图片文件名
        String uuid = UUID.randomUUID().toString();
        String orgFileName = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(orgFileName);
        String fileName = uuid + ext;
        try {
            // 写入图片
            File targetFile = new File(basePath, fileName);
            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());

            //压缩小图
            String smallImg = uuid + "_small" + ext;
            File smallTargetFile = new File(basePath, smallImg);
            Thumbnails.of(new File[]{targetFile}).scale(0.4D).toFile(smallTargetFile);
            return "/upload/" + fileName;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除图片文件
     *
     * @param imagePath 图片路径
     */
    public static void deleteFile(ServletContext servletContext, String imagePath) {
        String path = servletContext.getRealPath("/") + imagePath;
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        path = servletContext.getRealPath("/")
                + imagePath.substring(0, imagePath.indexOf(".")) + "_small"
                + imagePath.substring(imagePath.indexOf("."));
        file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }
}
