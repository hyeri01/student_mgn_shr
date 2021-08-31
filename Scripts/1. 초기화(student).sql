-- student_mgn
DROP SCHEMA IF EXISTS student_mgn;

-- student_mgn
CREATE SCHEMA student_mgn;

-- 학생
CREATE TABLE student_mgn.student (
	stdno   INTEGER     NOT NULL COMMENT '학번', -- 학번
	stdname VARCHAR(50) NOT NULL COMMENT '학생이름', -- 학생이름
	kor     INTEGER     NULL     COMMENT '국어', -- 국어
	eng     INTEGER     NULL     COMMENT '영어', -- 영어
	math    INTEGER     NULL     COMMENT '수학' -- 수학
)
COMMENT '학생';

-- 학생
ALTER TABLE student_mgn.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			stdno -- 학번
		);