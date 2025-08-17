# Schedule

프로젝트 구성

1.프로젝트 개발 환경: 런타임 버전: 21.0.7+9-b895.130 aarch64 (JCEF 122.1.9) VM: JetBrains s.r.o.의 OpenJDK 64-Bit Server VM 
JDK: corretto-17 Amazon Corretto-17.0.15 - aarch64

2. 개발 기간: 2025.08.11 ~ 2025.08.13
3. 날짜별 개발: 11일: lv1 일정 생성, 12일: lv1 일정 조회, lv1 일정 수정, 13일 lv1 일정 삭제, lv2 유저 crud
4. 기능: 1. 일정 CRUD, 유저 CRUD
5. 실행 방법 Java 17이상 설치 필요 Schedule2Application의 main() 실행시 프로그램 시작



# API 명세서
# 일정 관리
| 기능      | method | url                     | 설명        | 응답 코드       | Request                                                                                     | Response                                                                                                                                                         |
|---------|--------|-------------------------|-----------|-------------|---------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 생성   | POST   | /schedules              | 일정 생성 | 201 Created | {<br/>"name": "JS",<br/>"password": "1234",<br/>"title": "제목",<br/>"contents": "내용"<br/>}   | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                     |
| 일정 조회 | GET    | /schedules/             | 일정 전부 조회  | 200 OK      |                                                                                             | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>},<br/>{...},<br>.... |
| 일정 단건 조회 | GET    | /schedules/{id}         | 일정 단건 조회  | 200 OK      |                                                                                             | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                     |
| 일정 수정   | PUT    | /schedules/{id}         | 특정 일정 수정  | 200 OK      | {<br/>"name": "JS2",<br/>"password": "1234",<br/>"title": "제목2",<br/>"contents": "내용"<br/>} | {<br/>"id": 1,<br/>"name": "JS2",<br/>"title": "제목2",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-02"<br/>}                   |
| 일정 삭제   | DELETE | /schedules/{id}         | 특정 일정 삭제  | 200 OK      |                                                                                             | {}                                                                                                                                    |
# 유저 관리
| 기능      | method | url        | 설명                                | 응답 코드  | Request                                                                                                | Response                                                                                                                                                         |
|---------|--------|------------|-----------------------------------|--------|--------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 유저 생성   | POST   | /user      | 유저 생성                             | 200 OK | {<br/>"userName": "JS",<br/>"userPassword": "1234",<br/>"userEmail": "enmil"<br/>} | {<br/>"userId": 1,<br/>"userName": "JS",<br/>"userEmail": "email",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                           |
| 유저 조회 | GET    | /user      | 유저 전부 조회 또는 QueryParam으로 특정 유저 조회 | 200 OK |                                                                                                        | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>},<br/>{...},<br>.... |
| 유저 수정   | PUT    | /user/{userId} | 특정 유저 수정                          | 200 OK | {<br/>"userName": "JS2",<br/>"userPassword": "1234",<br/>"userEmail": "제목2"<br/>}             | {<br/>"userId": 1,<br/>"userName": "JS2",<br/>"userEmail": "email2",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-02"<br/>}    |
| 유져 삭제   | DELETE | /user/{userId} | 특정 유저 삭제                          | 200 OK |                                                                                                        | {}                                                                                                                                                               |
# 댓글 관리
| 기능       | method | url                                          | 설명       | 응답 코드  | Request                        | Response                                                                                                                                                              |
|----------|--------|----------------------------------------------|----------|--------|--------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 댓글 생성    | POST   | /schedules/{id}/comments                     | 댓글 등록    | 200 OK | {<br/>"comment": "댓글내용"<br/>}  | {<br/>"commentId": 1,<br/>"user": "JS",<br/>"comment": "댓글 내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                                   |
| 댓글 조회    | GET    | /schedules/{id}/comments             | 댓글 전부 조회 | 200 OK |                                | {<br/>"commentId": 1,<br/>"user": "JS",<br/>"comment": "댓글 내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>},<br/>{...},<br>.... |
| 댓글 단건 조회 | GET    | /schedules/{id}/comments/{commentId} | 댓글 단건 조회 | 200 OK |                                | {<br/>"commentId": 1,<br/>"user": "JS",<br/>"comment": "댓글 내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                           |
| 댓글 수정    | PUT    | /schedules/{id}/comments/{commentId} | 특정 댓글 수정 | 200 OK | {<br/>"comment": "댓글내용2"<br/>} | {<br/>"commentId": 1,<br/>"user": "JS",<br/>"comment": "댓글 내용2",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-02"<br/>}                               |
| 댓글 삭제    | DELETE | /schedules/{id}/comments/{commentId} | 특정 댓글 삭제 | 200 OK |                                | {}                                                                                                                                                                    |


# ERD
![img.png](img.png)
