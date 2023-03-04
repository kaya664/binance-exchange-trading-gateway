package com.kaya.trading.gateway.util

import com.kaya.trading.gateway.enum.BinanceSecurityType
import com.kaya.trading.gateway.enum.Endpoint
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.sign

@Service
class BinanceRequestProvider : IHttpRequestProvider {
    override fun getSignedUrl(endpoint: Endpoint): String {
        return getUrl(endpoint as Endpoint.BinanceEndpoint)
    }

    private fun getUrl(endpoint: Endpoint.BinanceEndpoint): String {
        val baseUrl = endpoint.baseUrl
        val restOfUrl = endpoint.endpoint.restOfUrl

        val allParams = when (val urlParams = endpoint.urlParams) {
            "" -> {
                if(endpoint.endpoint.needsTimestamp) {
                    "recvWindow=5000&timestamp=" + Date().time
                } else {
                    ""
                }
            }
            else -> {
                if(endpoint.endpoint.needsTimestamp) {
                    urlParams + "&recvWindow=5000&timestamp=" + Date().time
                } else {
                    urlParams
                }
            }
        }

        var signature = when (endpoint.endpoint.securityType) {
            BinanceSecurityType.USER_DATA, BinanceSecurityType.MARGIN, BinanceSecurityType.TRADE -> "&signature="+createSignature(allParams!!, endpoint.apiSecretKey)
            else -> ""
        }

        return "$baseUrl$restOfUrl?$allParams$signature"
    }
}