package com.kt.caike.common.header;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KtHeader {

    private final static String format = "yyyy.MM.dd HH:mm:ss";

    private String requestAt;

    private String responseAt;

    private String transactionId;

    private KtHeaderResult result;

    private KtHeaderNotice notice;

    @JsonIgnore
    public KtHeader(KtHeaderResult result, KtHeaderNotice notice){
        this.setResponseAt(now())
                .setResult(result)
                .setNotice(notice)
        ;
    }

    @JsonIgnore
    public KtHeader responseOk(){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().ok())
                .setNotice(KtHeaderNotice.builder().build().ok())
                ;
    }

    @JsonIgnore
    public KtHeader responseOk(KtHeader requestHeader){
        return this
                .setRequestAt(requestHeader.getRequestAt())
                .setResponseAt(now())
                .setTransactionId(requestHeader.getTransactionId())
                .setResult(KtHeaderResult.builder().build().ok())
                .setNotice(KtHeaderNotice.builder().build().ok())
                ;
    }

    @JsonIgnore
    public KtHeader validationError(){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().validationError())
                .setNotice(KtHeaderNotice.builder().build().validationError())
                ;
    }

    @JsonIgnore
    public KtHeader validationError(String description){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().validationError(description))
                .setNotice(KtHeaderNotice.builder().build().validationError())
                ;
    }

    @JsonIgnore
    public KtHeader validationError(String uri, String method, String description){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().validationError(uri, method, description))
                .setNotice(KtHeaderNotice.builder().build().validationError())
                ;
    }

    @JsonIgnore
    public KtHeader serverError(){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().serverError())
                .setNotice(KtHeaderNotice.builder().build().serverError())
                ;
    }

    @JsonIgnore
    public KtHeader serverError(String code, String description){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().serverError(code, description))
                .setNotice(KtHeaderNotice.builder().build().serverError())
                ;
    }

    @JsonIgnore
    public KtHeader serverError(String description){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().serverError(description))
                .setNotice(KtHeaderNotice.builder().build().serverError())
                ;
    }

    @JsonIgnore
    public KtHeader serverError(KtHeaderResult result, KtHeaderNotice notice){
        return this
                .setResponseAt(now())
                .setResult(result)
                .setNotice(notice)
                ;
    }

    @JsonIgnore
    public KtHeader serverError(String uri, String method, String description){
        return this
                .setResponseAt(now())
                .setResult(KtHeaderResult.builder().build().serverError(uri, method, description))
                .setNotice(KtHeaderNotice.builder().build().serverError())
                ;
    }

    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }
}
