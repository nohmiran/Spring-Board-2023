package com.example.board.entity;

import lombok.Getter;
import org.hibernate.annotations.Comment;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class InvalidEntity extends BaseEntity{

    @Comment("컬럼 삭제 여부")
    private boolean invalid;

    @Comment("컬럼 삭제 날짜")
    private LocalDateTime invalidDate;

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
        if(invalid) {
            invalidDate = LocalDateTime.now();
        } else {
            invalidDate = null;
        }
    }

    public InvalidEntity() {
        super();
    }

}
