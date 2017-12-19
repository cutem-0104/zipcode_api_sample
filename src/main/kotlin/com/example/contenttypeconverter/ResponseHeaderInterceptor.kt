package com.example.contenttypeconverter

import org.springframework.http.HttpRequest
import org.springframework.http.MediaType
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component

/**
 * レスポンスのヘッダを変更するインターセプタークラス
 */
@Component
class ResponseHeaderInterceptor : ClientHttpRequestInterceptor {

    /**
     * リクエスト実行し、実行後のレスポンスオブジェクトのContentTypeをapplication/jsonで上書きする
     */
    override fun intercept(request: HttpRequest,
                           body: ByteArray,
                           execution: ClientHttpRequestExecution): ClientHttpResponse {
        var response: ClientHttpResponse = execution.execute(request, body)
        response.headers.contentType = MediaType.APPLICATION_JSON
        return response
    }
}