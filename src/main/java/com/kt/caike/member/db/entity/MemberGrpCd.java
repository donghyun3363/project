package com.kt.caike.member.db.entity;

import com.kt.caike.common.ifs.BaseEntity;
import com.kt.caike.member.enums.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "member_grp_cd")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
/*
@SequenceGenerator(
        name="MEMBER_GRP_CD_SEQ_GEN",
        sequenceName = "MEMBER_GRP_CD_SEQ",
        initialValue = 1,
        allocationSize = 1
)
*/
public class MemberGrpCd implements BaseEntity<Long> {

    /*@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_GRP_CD_SEQ_GEN"
            )
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String groupCd;

    private String groupNm;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;
}
