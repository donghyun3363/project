package com.kt.caike.member.db.entity;

import com.kt.caike.common.ifs.BaseEntity;
import com.kt.caike.member.enums.MemberStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "member")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
/*
@SequenceGenerator(
        name="MEMBER_SEQ_GEN",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
*/
public class Member implements BaseEntity<Long> {

    /*@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GEN"
            )
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    MemberStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

}
