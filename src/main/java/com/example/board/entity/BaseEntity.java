
package com.example.board.entity;

import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @Comment("컬럼 생성 날짜")
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Comment("컬럼 수정 날짜")
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updatedDate;

    public BaseEntity() {
    }
}

