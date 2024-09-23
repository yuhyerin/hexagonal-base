package com.example.hexagonal.adapters.output

import com.example.hexagonal.port.output.EmailUseCase
import org.springframework.stereotype.Component


@Component
class EmailApiAdapter : EmailUseCase {

    override fun sendVerificationEmail(memberId: Long, email: String): String {
        // TODO
        val authCode = "123456" // 인증 코드 생성 (예시)
        println("Sending email to $email with auth code: $authCode")
        return authCode
    }
}