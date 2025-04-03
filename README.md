# ScheduleProject-JPA

![erd.PNG](png/erd.PNG)

![login api.PNG](png/login%20api.PNG)

![writer api.PNG](png/writer%20api.PNG)

![schedule api.PNG](png/schedule%20api.PNG)

위 사진에 나오지 않은 writer의 response와 schedule의 response를 아래 표로 만들었습니다. schedule 응답은 다 같은 형태라 하나만 올렸습니다.


| writer 단건 일정 응답 body                                                                                  | writer 수정 응답 body|schedule 응답 body|
|-------------------------------------------------------------------------------------------------------|---|---|
| {<br>”id”: “아이디값”, <br>”writer”:  “유저명”,<br> ”creationdate”:  “작성일”, <br> ”modificationdate”: ”수정일” <br>} | {<br>”id”: 아이디값,<br>”writer”: “유저명”,<br>”email” : “이메일”,<br>”password”: “비밀번호”,<br>”creationdate”:  “작성일”,<br>”modificationdate”: “수정일”<br>}  | {<br>”id”: 아이디값,<br>”writer_id”: “유저아이디값”,<br>”title”:  “할 일 제목”,<br>”contents”:  “할 일 내용”,<br>"creationdate”:  “작성일”,<br>”modificationdate”: “수정일”<br>}|





