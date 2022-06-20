package com.liu.managerial_system.controller.achievement;


import com.liu.managerial_system.dto.AchievementDto;
import com.liu.managerial_system.service.AchievementService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/10 13:39
 */
@RestController
@RequestMapping("/achieve")
public class AchievementController {
    @Autowired
    private HttpServletRequest request;

    @Autowired(required = false)
    private HttpServletResponse resp;
    @Resource
    private AchievementService achievementService;

    @RequestMapping("/add_new_achieve")
    public void addNewAchievement(@RequestParam("files") MultipartFile[] files, @ModelAttribute(value = "achievementdto") AchievementDto achievementDto) {
        achievementService.insertNewAchievement(files, achievementDto);
        try {
            resp.sendRedirect("/manage/showmyachievement");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/get_achievement_by_id")
    public String getAchievementById(String id) {
        return achievementService.getAchievementById(id);
    }

    @RequestMapping("/get_achievement_files_by_id")
    public String getAchievementFilesById(String id) {
        return achievementService.getAchievementFilesById(id);
    }

    @RequestMapping("/downloadfile/{id}/{filename}")
    public void downLoadFile(@PathVariable(name = "id") String id, @PathVariable(name = "filename") String filename) {
        resp.setContentType("application/x-download charset=UTF-8");
        //设置文件MIME类型
        String filenameEncode = null;
        InputStream in;
        OutputStream out;
        try {
            filenameEncode = URLEncoder.encode(filename, "UTF-8");
            //设置Content-Disposition
            resp.setHeader("Content-Disposition", "attachment;filename=" + filenameEncode);
            //读取目标文件，通过response将目标文件写到客户端
            //获取目标文件的绝对路径
            String filePath = System.getProperty("user.dir") + "\\achievement\\" + id + "\\" + filename;
            //读取文件
            in = new FileInputStream(filePath);
            out = resp.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            //循环取出流中的数据
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in = null;
            out = null;
        }
    }

    @RequestMapping("/edit_achieve")
    public String editAchievement(String formdata) {
        achievementService.editAchievement(formdata);
        return "success";
    }

    @RequestMapping("/delete_achievement_by_id")
    public void deleteAchievement(String id) {
        achievementService.deleteById(id);
    }

    @RequestMapping("add_new_files")
    public void addNewFiles(@RequestParam("files") MultipartFile[] files, String dirid) {
        achievementService.addNewFiles(files, dirid);
        try {
            resp.sendRedirect("/manage/showmyachievement");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
