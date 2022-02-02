package com.kt.caike.common.ifs;

import java.time.LocalDateTime;

public interface BaseEntity<ID> {
    ID getId();
    String getCreatedBy();
    String getUpdatedBy();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    BaseEntity setCreatedBy(String createdBy);
    BaseEntity setUpdatedBy(String updatedBy);
    BaseEntity setCreatedAt(LocalDateTime createdAt);
    BaseEntity setUpdatedAt(LocalDateTime updatedAt);
}
