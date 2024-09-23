package com.example.hexagonal.adapters.input

import com.example.hexagonal.domain.model.Member
import com.example.hexagonal.port.input.MemberUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/members")
class MemberController(
    private val memberUseCase: MemberUseCase
) {

    @PostMapping("/register")
    fun registerMember(
        @RequestParam name: String,
        @RequestParam email: String,
        @RequestParam password: String
    ): ResponseEntity<Member> {
        val member = memberUseCase.registerMember(name, email, password)
        return ResponseEntity.ok(member)
    }

    @PostMapping("/verify")
    fun verifyEmail(
        @RequestParam memberId: Long,
        @RequestParam authCode: String
    ): ResponseEntity<Boolean> {
        val verified = memberUseCase.verifyEmail(memberId, authCode)
        return ResponseEntity.ok(verified)
    }
}