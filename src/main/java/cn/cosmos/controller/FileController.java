package cn.cosmos.controller;


import cn.cosmos.utils.UploadDownLoadUtil;
import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with CosmosRay
 *
 * @author CosmosRay
 * @date 2019/12/23
 * Funciton:
 */
@Controller
public class FileController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    /**
     * 单文件上传
     */
    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        return UploadDownLoadUtil.upload(file);
    }

    /**
     * 单文件下载相关代码
     */
    @RequestMapping("/download")
    public String downloadFile(HttpServletResponse response, String fileName) {
        return UploadDownLoadUtil.downloadFile(response, fileName);
    }

    /**
     * 多文件上传
     */
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        return UploadDownLoadUtil.handleFileUpload(request);
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.today());
    }
}
