package com.kaya.trading.gateway.service

import com.kaya.trading.gateway.enum.Endpoint
import com.kaya.trading.gateway.util.IHttpRequestProvider
import com.kaya.trading.gateway.util.RequestProviderContext
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import java.util.*

@Service
class HttpHandlerService(restTemplateBuilder: RestTemplateBuilder, val requestProviderContext: RequestProviderContext) {

    private var restTemplate: RestTemplate = restTemplateBuilder.build()

    fun sendRequest(endpoint: Endpoint, headers: MutableMap<String, String>, httpMethod: HttpMethod) {
        var httpHeaders: HttpHeaders = HttpHeaders()
        headers += getHttpHeadersByEndpointType(endpoint)
        if (headers.isNotEmpty()) {
            headers.forEach { (t, u) ->
                httpHeaders.set(t, u)
            }
        }
        var httpEntity: HttpEntity<String> = HttpEntity(httpHeaders)
        var responseEntity: ResponseEntity<String> =
            restTemplate.exchange(getUrlByEndpointType(endpoint), httpMethod, httpEntity)
        print(responseEntity)
    }

    private fun getHttpHeadersByEndpointType(endpoint: Endpoint): MutableMap<String, String> {
        var map: MutableMap<String, String> = mutableMapOf()
        when (endpoint) {
            is Endpoint.BinanceEndpoint -> map["X-MBX-APIKEY"] = endpoint.apiClientKey
        }
        return map
    }

    private fun getUrlByEndpointType(endpoint: Endpoint): String {
        return requestProviderContext.getContext(endpoint).getSignedUrl(endpoint)
    }

}