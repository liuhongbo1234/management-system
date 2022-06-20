package com.liu.managerial_system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liu.managerial_system.controller.achievement.AchievementController;
import com.liu.managerial_system.domain.Achievement;
import com.liu.managerial_system.domain.AchievementExample;
import com.liu.managerial_system.dto.AchievementDto;
import com.liu.managerial_system.mapper.AchievementMapper;
import com.liu.managerial_system.util.CopyUtil;
import com.liu.managerial_system.util.UploadFileUtil;
import com.liu.managerial_system.util.UuidUtil;
import jdk.internal.util.xml.impl.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/10 16:13
 */
@Service
public class AchievementService {
    @Resource
    private AchievementMapper achievementMapper;

    public void addNewFiles(MultipartFile[] files, String dirid) {
        UploadFileUtil.upLoadFile(files, dirid);
    }

    public void insertNewAchievement(MultipartFile[] files, AchievementDto achievementDto) {
        String id = UuidUtil.getShortUuid();
        achievementDto.setId(id);
        UploadFileUtil.upLoadFile(files, id);
        Achievement achievement = CopyUtil.copy(achievementDto, Achievement.class);
        achievementMapper.insert(achievement);
    }

    public List<AchievementDto> getAllAchievementByUsername(String username) {
        AchievementExample achievementExample = new AchievementExample();
        achievementExample.createCriteria().andUsernameEqualTo(username);
        return CopyUtil.copyList(achievementMapper.selectByExample(achievementExample), AchievementDto.class);
    }

    public String getAchievementById(String id) {
        AchievementExample achievementExample = new AchievementExample();
        achievementExample.createCriteria().andIdEqualTo(id);
        List<AchievementDto> achievementDtoList = CopyUtil.copyList(achievementMapper.selectByExample(achievementExample), AchievementDto.class);
        return JSON.toJSONString(achievementDtoList);
    }

    public String getAchievementFilesById(String id) {
        String filePath = System.getProperty("user.dir") + "\\achievement\\" + id;
        File file = new File(filePath);
        List<Map<String, String>> list = new ArrayList<>();
        if (file != null && file.exists()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    Map<String, String> map = new HashMap<>();
                    map.put("text", "<a class='ace-icon fa fa-file-text grey' href='/manage/achieve/downloadfile/" + id + "/" + file1.getName() + "'>" + file1.getName() + "</a>");
                    map.put("type", "item");
                    list.add(map);
                }
                return JSON.toJSONString(list);
            } else {
                return "[]";
            }
        } else {
            return "[]";
        }
    }

    public void editAchievement(String formdata) {
        Object parse = JSONObject.parse(formdata);
//        String formatJson = parse.toString();
        List<Map<String, String>> list = (List<Map<String, String>>) parse;
        AchievementDto achievementDto = new AchievementDto();
        String id = "";
        for (Map<String, String> map : list) {
            switch (map.get("name")) {
                case "name":
                    achievementDto.setName(map.get("value"));
                    break;
                case "id":
                    id = map.get("value");
                    break;
                case "process":
                    achievementDto.setProcess(map.get("value"));
                    break;
                case "achieveCatagory":
                    achievementDto.setAchieveCatagory(map.get("value"));
                    break;
                case "application":
                    achievementDto.setApplication(map.get("value"));
                    break;
                case "firstAuthor":
                    achievementDto.setFirstAuthor(map.get("value"));
                    break;
                case "secondAuthor":
                    achievementDto.setSecondAuthor(map.get("value"));
                    break;
                case "thirdAuthor":
                    achievementDto.setThirdAuthor(map.get("value"));
                    break;
                case "otherAuthors":
                    achievementDto.setOtherAuthors(map.get("value"));
                    break;
                case "funds":
                    achievementDto.setFunds(map.get("value"));
                    break;
                case "level":
                    achievementDto.setLevel(map.get("value"));
                    break;
                case "othermsg":
                    achievementDto.setOthermsg(map.get("value"));
                    break;
                case "time":
                    achievementDto.setTime(map.get("value"));
                    break;
                case "resource":
                    achievementDto.setResource(map.get("value"));
                    break;
            }
        }

        AchievementExample achievementExample = new AchievementExample();
        achievementExample.createCriteria().andIdEqualTo(id);
        achievementMapper.updateByExampleSelective(CopyUtil.copy(achievementDto, Achievement.class), achievementExample);
    }

    public void deleteById(String id) {
        achievementMapper.deleteByPrimaryKey(id);
    }

    public List<AchievementDto> getAllAchievement() {
        AchievementExample achievementExample = new AchievementExample();
        List<Achievement> achievementList = achievementMapper.selectByExample(achievementExample);
        return CopyUtil.copyList(achievementList, AchievementDto.class);
    }
}
