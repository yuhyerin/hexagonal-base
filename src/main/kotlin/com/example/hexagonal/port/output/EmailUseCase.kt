package com.example.hexagonal.port.output

interface EmailUseCase {
    fun sendVerificationEmail(memberId: Long, email: String): String // 이메일 인증 코드를 전송
}