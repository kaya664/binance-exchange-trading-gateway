package com.kaya.trading.gateway.util

import com.kaya.trading.gateway.enum.Endpoint
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.apache.commons.codec.binary.Hex

interface IHttpRequestProvider {

    fun getSignedUrl(endpoint: Endpoint): String

    fun createSignature(data: String, key: String): String? {
        if (data.isNotEmpty()) {
            val sha256Hmac = Mac.getInstance("HmacSHA256")
            val secretKey = SecretKeySpec(key.toByteArray(), "HmacSHA256")
            sha256Hmac.init(secretKey)
            return Hex.encodeHexString(sha256Hmac.doFinal(data.toByteArray()))
        } else {
            return data
        }
    }
}