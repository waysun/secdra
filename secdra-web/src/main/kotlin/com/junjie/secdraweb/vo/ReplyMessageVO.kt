package com.junjie.secdraweb.vo

import com.junjie.secdradata.database.primary.entity.ReplyMessage
import org.springframework.beans.BeanUtils
import java.util.*

class ReplyMessageVO {
    lateinit var id: String
    //评论id
    lateinit var commentId: String
    //回复id
    lateinit var replyId: String
    //图片作者id
    lateinit var authorId: String
    //图片id
    lateinit var pictureId: String
    //评论人id
    lateinit var criticId: String
    //回答者id
    lateinit var answererId: String

    lateinit var content: String

    lateinit var createDate: Date

    lateinit var answerer: UserVO

    constructor()

    constructor(replyMessage: ReplyMessage) {
        BeanUtils.copyProperties(replyMessage, this)
    }

    constructor(replyMessage: ReplyMessage, answerer: UserVO) {
        BeanUtils.copyProperties(replyMessage, this)
        this.answerer = answerer
    }
}