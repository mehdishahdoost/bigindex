package com.github.mehdishahdoost.service

import com.github.mehdishahdoost.model.Login
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class LoginService(val passwordEncoder: PasswordEncoder, val userDetailsService: ReactiveUserDetailsService) {


    suspend fun userLogin(login: Login): String {
        val user = userDetailsService.findByUsername(login.username).awaitSingleOrNull()

        user?.let {
            if (passwordEncoder.matches(login.password, it.password))
                return "sample"
        }
        throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
    }


}