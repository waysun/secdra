package com.junjie.secdraweb.controller

import com.junjie.secdracore.annotations.RestfulPack
import com.junjie.secdracore.model.Result
import com.junjie.secdradata.database.primary.dao.PictureDAO
import com.junjie.secdraweb.core.component.BaseConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.junjie.secdraweb.core.qiniu.Auth as QiniuAuth


@RestController
@RequestMapping("qiniu")
class QiniuController(private val baseConfig: BaseConfig, private val pictureDAO: PictureDAO) {
    @GetMapping("/getUploadToken")
    @RestfulPack
    fun get(): Result<String> {
        val auth = QiniuAuth.create(baseConfig.qiniuAccessKey, baseConfig.qiniuSecretKey)
        return Result(200, "", auth.uploadToken(baseConfig.qiniuTempBucket))
    }
}


