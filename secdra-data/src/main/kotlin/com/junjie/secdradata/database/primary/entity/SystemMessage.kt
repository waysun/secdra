package com.junjie.secdradata.database.primary.entity

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

/**
 * 系统通知消息
 * @author fjj
 */
@Entity
@EntityListeners(AuditingEntityListener::class)
class SystemMessage {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    var id: String? = null

    lateinit var userId: String

    lateinit var title: String

    @Column(columnDefinition = "text")
    lateinit var content: String
    // 由于read是数据库保留字
    var review: Boolean = false

    @CreatedDate
    var createDate: Date? = null

    constructor()

    constructor(userId: String, title: String, content: String) {
        this.userId = userId
        this.title = title
        this.content = content
    }
}