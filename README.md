# 개발 환경
1. IDE: IntelliJ IDEA Community
2. Spring Boot 2.7.14
3. JDK 17
4. mysql
5. Spring Data JPA
6. Thymeleaf

# 주요 기능
1. 타임리프를 이용한 게시판(/board)
   1. 글쓰기(/save)
   2. 글목록(/)
   3. 글상세보기(/{id})
   4. 글수정(/update/{id})
      - 상세화면에서 수정버튼 클릭
      - 서버에서 해당 게시글의 정보를 가지고 수정화면 출력
      - 제목, 내용 수정 입력 받아서 서버로 요청
      - 수정 처리
   5. 글삭제(/delete)
   6. 페이징처리(/paging)
   <br><br>
2. ajax를 이용한 게시판