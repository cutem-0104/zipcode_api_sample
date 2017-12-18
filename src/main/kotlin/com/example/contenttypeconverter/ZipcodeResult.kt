package com.example.contenttypeconverter

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * zipcodeレスポンスデータクラス
 */
data class ZipcodeResult(@JsonProperty(value = "status") var status: Int? = 0,
                         @JsonProperty(value = "message") var message: String? = "",
                         @JsonProperty(value = "results") var results: List<ZipcodeResponse>? = listOf())

/**
 * resultsレスポンスデータクラス
 */
data class ZipcodeResponse(@JsonProperty(value = "address1") var address1: String? = "",
                           @JsonProperty(value = "address2") var address2: String? = "",
                           @JsonProperty(value = "address3") var address3: String? = "",
                           @JsonProperty(value = "kana1") var kana1: String? = "",
                           @JsonProperty(value = "kana2") var kana2: String? = "",
                           @JsonProperty(value = "kana3") var kana3: String? = "",
                           @JsonProperty(value = "prefcode") var prefcode: String? = "",
                           @JsonProperty(value = "zipcode") var zipcode: String? = "")