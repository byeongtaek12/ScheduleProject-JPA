CREATE TABLE schedulev2
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
    user_id BIGINT COMMENT '유저 식별자',
    title VARCHAR(100) COMMENT '제목',
    contents VARCHAR(200) COMMENT '내용',
    createdAt DATETIME COMMENT '작성일',
    modifiedAt DATETIME COMMENT '수정일',
    FOREIGN KEY (user_id) REFERENCES writer(id)
);

CREATE TABLE writer
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '유저 식별자',
    writer VARCHAR(50) NOT NULL COMMENT '유저명',
    email VARCHAR(100) NOT NULL COMMENT '이메일',
    password VARCHAR(100) NOT NULL COMMENT '비밀번호',
    createdAt DATETIME COMMENT '작성일',
    modifiedAt DATETIME COMMENT '수정일'
);