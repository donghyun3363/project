package com.kt.caike.common.header;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KtHeaderResult {

    private String code;

    private String message;

    private String description;

    private String requestUri;

    private String requestMethod;


    @JsonIgnore
    public KtHeaderResult ok() {
        return this.setCode(String.valueOf(HttpStatus.OK.value()))              /* OK : 200 */
                .setDescription("성공")
                .setMessage("정상처리되었습니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult validationError() {
        return this.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))     /* BAD_REQUEST : 400 */
                .setDescription("잘못 된 요청입니다.")
                .setMessage("잘못 된 요청입니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult validationError(String description) {
        return this.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .setDescription(description)
                .setMessage("잘못 된 요청입니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult validationError(String uri, String method, String description) {
        return this.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .setRequestUri(uri)
                .setRequestMethod(method)
                .setDescription(description)
                .setMessage("잘못 된 요청입니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult serverError() {
        return this.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))       /* INTERNAL_SERVER_ERROR : 500 */
                .setDescription("서버 에러 입니다.")
                .setMessage("서버 에러 입니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult serverError(String code, String description) {
        return this.setCode(code)
                .setDescription(description)
                .setMessage("서버 에러 입니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult serverError(String description) {
        return this.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .setDescription(description)
                .setMessage("서버 에러 입니다.")
                ;
    }

    @JsonIgnore
    public KtHeaderResult serverError(String uri, String method, String description) {
        return this.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .setRequestUri(uri)
                .setRequestMethod(method)
                .setDescription(description)
                .setMessage("서버 에러 입니다.")
                ;
    }
}