package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {


    // jpql(java persistence query language)
    @Modifying
    @Query(value = "update BoardEntity b set b.hits = b.hits + 1 where b.id = :id")
    void boardHits(@Param("id") Long id);
}
