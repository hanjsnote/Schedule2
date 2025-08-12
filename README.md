# Schedule
# API 명세서
# 일정 관리
| 기능       | method | url                     | 설명             | 응답 코드       | Request                                                                                     | Response                                                                                                                                                         |
|----------|--------|-------------------------|----------------|-------------|---------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 등록    | POST   | /schedules              | 새로운 일정 등록      | 201 Created | {<br/>"name": "JS",<br/>"password": "1234",<br/>"title": "제목",<br/>"contents": "내용"<br/>}   | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                     |
| 일정 전부 조회 | GET    | /schedules/             | 일정 전부 조회       | 200 OK      |                                                                                             | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>},<br/>{...},<br>.... |
| 일정 단건 조회 | GET    | /schedules/{id}         | 일정 단건 조회       | 200 OK      |                                                                                             | {<br/>"id": 1,<br/>"name": "JS",<br/>"title": "제목",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-01"<br/>}                     |
| 일정 수정    | PUT    | /schedules/{id}         | 특정 일정 수정     | 200 OK      | {<br/>"name": "JS2",<br/>"password": "1234",<br/>"title": "제목2",<br/>"contents": "내용"<br/>} | {<br/>"id": 1,<br/>"name": "JS2",<br/>"title": "제목2",<br/>"contents":"내용",<br/>"createdAt": "2025-08-01",<br/>"modifiedAt": "2025-08-02"<br/>}                   |
| 일정 삭제    | DELETE | /schedules/{id}         | 특정 일정 삭제     | 200 OK      |                                                                                             | {}                                                                                                                                    |

# ERD
