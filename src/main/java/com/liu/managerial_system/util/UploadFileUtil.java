package com.liu.managerial_system.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/12 22:09
 */
public class UploadFileUtil {
    public static void upLoadFile(MultipartFile[] files, String id) {
        if (files != null && files.length > 0 && files[0].getOriginalFilename() != null) {
            String filePath = System.getProperty("user.dir") + "\\achievement\\" + id;
            File fileDir = new File(filePath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            InputStream in = null;
            OutputStream out = null;
            for (MultipartFile file : files) {
                byte[] bytes = new byte[1000];
                int byteread = 0;
                try {
                    in = file.getInputStream();
                    out = new FileOutputStream(filePath + "\\" + file.getOriginalFilename());
                    while ((byteread = in.read(bytes)) != -1) {
                        out.write(bytes, 0, byteread);
                    }
                } catch (IOException e) {

                } finally {
                    try {
                        if (out != null && in != null) {
                            out.close();
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        out = null;
                        in = null;
                    }
                }
            }
        }
    }
}
