package com.kt.caike.common.header;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KtHeaderNotice {

    private Boolean isVisibility;

    private String type;

    private String message;

    @JsonIgnore
    public KtHeaderNotice ok(){
        return this.setIsVisibility(false)
                .setMessage("")
                .setType("")
                ;
    }

    @JsonIgnore
    public KtHeaderNotice validationError(){
        return this.setIsVisibility(true)
                .setMessage("잘못 된 요청입니다. 계속되는 경우 고객센터로 문의해주세요.")
                .setType("ALERT-TYPE_1")
                ;
    }

    @JsonIgnore
    public KtHeaderNotice serverError(){
        return this.setIsVisibility(true)
                .setMessage("서버 에러 입니다. 계속되는 경우 고객센터로 문의해주세요.")
                .setType("ALERT-TYPE_1")
                ;
    }

    @JsonIgnore
    public KtHeaderNotice serverError(String message){
        return this.setIsVisibility(true)
                .setMessage(message)
                .setType("ALERT-TYPE_1")
                ;
    }
}
