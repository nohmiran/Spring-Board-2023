# 개발 환경
1. IDE: IntelliJ IDEA Community
2. Spring Boot 2.7.14
3. JDK 17
4. mysql
5. Spring Data JPA
6. Thymeleaf

# 주요 기능
1. user 관리 기능 ---> (예정)
   1. 회원가입 & 로그인 (시큐리티 적용)
   2. 유저 정보 관리
      - 프로필 사진 변경
      - 닉네임 변경
      - ...등등 ㅠㅠ
      <br><br>
2. 타임리프를 이용한 게시판 ---> (완성)
   1. 글쓰기(/board/save)
   2. 글목록(/board/)
   3. 글상세보기(/board/{id})
   4. 글수정(/board/update/{id})
      - 상세화면에서 수정버튼 클릭
      - 서버에서 해당 게시글의 정보를 가지고 수정화면 출력
      - 제목, 내용 수정 입력 받아서 서버로 요청
      - 수정 처리
   5. 글삭제(/board/delete/{id})
   6. 페이징처리(/board/paging)
   <br><br>
3. ajax를 이용한 게시판 ---> (예정)
   <br><br>
4. 개발하고 싶었던 ㅇㅇ기반 게시판(쉿..secret) ---> (예정)