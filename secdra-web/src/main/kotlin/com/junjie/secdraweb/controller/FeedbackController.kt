package com.junjie.secdraweb.controller

import com.junjie.secdracore.annotations.RestfulPack
import com.junjie.secdradata.database.primary.entity.Feedback
import com.junjie.secdraservice.service.FeedbackService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 反馈信息
 * @author fjj
 */
@RestController
@RequestMapping("feedback")
class FeedbackController(private val feedbackService: FeedbackService) {
    /**
     * 提交反馈
     */
    @GetMapping("/save")
    @RestfulPack
    fun save(content: String, email: String?): Feedback {
        return feedbackService.save(Feedback(content, email))
    }
}