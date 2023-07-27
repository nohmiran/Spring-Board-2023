package com.example.board.repository;

import com.example.board.entity.QBoardEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardQueryDslRepository {

    private final JPAQueryFactory queryFactory;
    private final QBoardEntity qBoard = QBoardEntity.boardEntity;

    public BoardQueryDslRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public void updateHits(Long id){
        queryFactory.update(qBoard)
                .set(qBoard.hits, qBoard.hits.add(1))
                .where(qBoard.id.eq(id))
                .execute();
    }

}
