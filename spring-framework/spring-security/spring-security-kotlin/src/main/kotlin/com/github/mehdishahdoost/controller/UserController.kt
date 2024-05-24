package com.github.mehdishahdoost.controller

import com.github.mehdishahdoost.model.Login
import com.github.mehdishahdoost.model.Profile
import com.github.mehdishahdoost.service.LoginService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class UserController(val loginService: LoginService) {

    @GetMapping("/me")
    fun me(@AuthenticationPrincipal principal: Principal): Profile = Profile(principal.name)

    @PostMapping("/login")
    suspend fun login(@RequestBody login: Login): String  = loginService.userLogin(login)

}