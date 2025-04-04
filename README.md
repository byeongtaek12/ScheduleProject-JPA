# ScheduleProject-JPA

Spring-JPA 사용하여 level0, 1, 2, 3, 4 challenge leve5,6,7,8  단계별로 일정 관리 앱 만들기
<br>
<br>
각각의 브랜치 read.me도 있으니 확인해주세요.
<br>
level0은 main브랜치에 했고 lv1~lv5는 합쳐서 했고 lv6은 따로 했습니다.
-------

## 프로젝트 개요

프로젝트명 : 일정 관리 앱 <br>

프로젝트 목적 :

- Spring의 기초 학습
- 웹 개발에 필수적인 CRUD (Create, Read, Update, Delete) 기능을 구현
- JPA를 실습하여 데이터베이스와의 직접적인 연동을 이해하기

사용언어 : Java

-----

## 레벨별 요구 사항

-----
### 필수기능 Lv1, Lv2, LV3 , LV4 도전기능  LV5, LV6구현⭕<br>

---
### 도전기능 LV7, LV8 구현❌ <br>

------

## Lv 0. API 명세 및 ERD 작성
- API 명세서 작성
- ERD 작성
- SQL 작성
### ERD

![erd.PNG](png/erd.PNG)

### API

![login api.PNG](png/login%20api.PNG)

![writer api.PNG](png/writer%20api.PNG)

![schedule api.PNG](png/schedule%20api.PNG)

위 사진에 나오지 않은 writer의 response와 schedule의 response를 아래 표로 만들었습니다. schedule 응답은 다 같은 형태라 하나만 올렸습니다.


| writer 단건 일정 응답 body                                                                                  | writer 수정 응답 body|schedule 응답 body|
|-------------------------------------------------------------------------------------------------------|---|---|
| {<br>”id”: “아이디값”, <br>”writer”:  “유저명”,<br> ”creationdate”:  “작성일”, <br> ”modificationdate”: ”수정일” <br>} | {<br>”id”: 아이디값,<br>”writer”: “유저명”,<br>”email” : “이메일”,<br>”password”: “비밀번호”,<br>”creationdate”:  “작성일”,<br>”modificationdate”: “수정일”<br>}  | {<br>”id”: 아이디값,<br>”writer_id”: “유저아이디값”,<br>”title”:  “할 일 제목”,<br>”contents”:  “할 일 내용”,<br>"creationdate”:  “작성일”,<br>”modificationdate”: “수정일”<br>}|

### SQL
최상단 sql 파일을 봐주세요.
















