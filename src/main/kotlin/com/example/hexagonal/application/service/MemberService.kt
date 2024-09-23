package com.example.hexagonal.application.service

import com.example.hexagonal.domain.model.Member
import com.example.hexagonal.port.input.MemberUseCase
import com.example.hexagonal.port.output.EmailUseCase
import com.example.hexagonal.port.output.repository.MemberRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val emailUseCase: EmailUseCase
) : MemberUseCase {

    override fun registerMember(name: String, email: String, password: String): Member {
        val member = Member(name = name, email = email, password = password)
        val savedMember = memberRepository.save(member)

        // 이메일 인증 코드 발송
        emailUseCase.sendVerificationEmail(savedMember.id!!, savedMember.email)

        return savedMember
    }

    override fun verifyEmail(memberId: Long, authCode: String): Boolean {
        val member = memberRepository.findById(memberId) ?: throw IllegalArgumentException("Member not found")

        // 인증 로직 추가
        member.emailVerified = true
        memberRepository.save(member)

        return member.emailVerified
    }
}