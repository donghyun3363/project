package com.kt.caike.common.request;


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
public class Pagination {

    private int page = 0;                   // default 0
    private int size = 20;                  // default 20

    private Integer totalElements;
    private Integer totalPage;

    private Integer currentElements;
    private Integer currentPage;

    private String orderBy = "id";          // default id
    private String sortBy = "ASC";          // default ASC [ASC, DESC]

    private int limit = 0;

    public int getLimit() {
        return (page * size);
    }

    public void complete(){
        this.currentPage = page;
        this.totalPage = (int) Math.ceil((double) totalElements / size);
    }
}