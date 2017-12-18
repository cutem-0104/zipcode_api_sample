package com.example.contenttypeconverter

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

/**
 * zipcodeAPIを呼び出すクラス
 */
@Component
class RestClient(restTemplateBuilder: RestTemplateBuilder,
                 interceptor: ResponseHeaderInterceptor) {
    val apiUri: String = "http://zipcloud.ibsnet.co.jp/api/search"
    lateinit var restTemplate: RestTemplate

    /**
     * zipcodeAPIへリクエストを送り、レスポンスを受け取る
     */
    fun request(zipcode: String): ZipcodeResult {
        val targetUri: URI = UriComponentsBuilder
                .fromUriString(apiUri)
                .query("zipcode={zipcode}")
                .buildAndExpand(zipcode)
                .toUri()
        val result: ZipcodeResult = restTemplate.getForObject(targetUri, ZipcodeResult::class.java)
        return result
    }

    init {
        restTemplate = restTemplateBuilder.additionalInterceptors(interceptor).build()
    }
}