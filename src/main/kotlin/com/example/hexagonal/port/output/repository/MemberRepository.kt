package com.example.hexagonal.port.output.repository

import com.example.hexagonal.domain.model.Member

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Long): Member?
}