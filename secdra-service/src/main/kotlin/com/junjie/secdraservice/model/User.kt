package com.junjie.secdraservice.model

import com.junjie.secdraservice.contant.Gender
import com.junjie.secdraservice.contant.UserState
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import java.util.Date
import javax.persistence.*

/**
 * 用户
 *
 * @author fjj
 */
@Entity
class User{
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    var id: String? = null

    var phone: String? = null

    var password: String? = null

    var name: String? = null

    var gender: Gender? = null

    var head: String? = null

    var birthday: Date? = null

    var introduction: String? = null

    var rePasswordDate: Date? = null

    var userState: UserState? = null

    @CreatedDate
    var createDate: Date = Date()

    @LastModifiedDate
    var modifiedDate: Date = Date()
}
