package com.lkf.ttshop.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/10/31
 * Time: 11:36
 * Version:V1.0
 * 上传图片至服务器的接口
 */
public interface FileService {

    Map<String,Object> uploadImages(MultipartFile upfile);
}
