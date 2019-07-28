package com.junjie.secdraadmin.controller

import com.junjie.secdraservice.dao.IFollowDao
import com.junjie.secdraservice.dao.IUserDao
import com.junjie.secdraservice.model.Follow
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("follow")
class FollowController(private var userDao: IUserDao, private var followDao: IFollowDao) {
    @PostMapping("/init")
    fun init(): Any {
        val userList = userDao.findAll()
        for (user in userList) {
            val takeList = userList.shuffled().take(50)
            for (take in takeList) {
                if (take.id.isNullOrEmpty() || user.id.isNullOrEmpty() || take.id == user.id) {
                    continue
                }
                if (followDao.existsByFollowerIdAndFollowingId(user.id!!, take.id!!)) {
                    continue
                }
                val follower = Follow()
                follower.followerId = user.id
                follower.followingId = take.id
                followDao.save(follower)
            }
        }
        return true
    }
}