package com.junjie.secdradata.database.primary.dao

import com.junjie.secdradata.database.primary.entity.CommentMessage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface CommentMessageDAO : JpaRepository<CommentMessage, String>, JpaSpecificationExecutor<CommentMessage> {
    fun findAllByAuthorIdOrderByCreateDateDesc(authorId: String): List<CommentMessage>

    fun countByAuthorIdAndReview(authorId: String, review: Boolean): Long

    fun findAllByAuthorIdAndReviewOrderByCreateDateDesc(authorId: String, review: Boolean): List<CommentMessage>
}