package com.example.hexagonal.adapters.output.jpa

import com.example.hexagonal.domain.model.Member
import com.example.hexagonal.port.output.repository.MemberRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaMemberRepository : MemberRepository, JpaRepository<Member, Long> {

}