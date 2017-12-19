package com.example.contenttypeconverter

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * コントローラークラス
 */
@RestController
class ApiController {

    /**
     * zipcodeAPIの呼び出し
     */
    @GetMapping("/test")
    fun callApi(@RequestParam zipcode: String): ZipcodeResult {
        val restClient: RestClient = RestClient(RestTemplateBuilder(), ResponseHeaderInterceptor())
        val zipcodeResult = restClient.request(zipcode)
        if (zipcodeResult.message == null) {
            zipcodeResult.message = ""
        }

        return zipcodeResult
    }
}