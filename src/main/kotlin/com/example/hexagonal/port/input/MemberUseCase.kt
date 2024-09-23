package com.example.hexagonal.port.input

import com.example.hexagonal.domain.model.Member

interface MemberUseCase {
    fun registerMember(name: String, email: String, password: String): Member
    fun verifyEmail(memberId: Long, authCode: String): Boolean
}