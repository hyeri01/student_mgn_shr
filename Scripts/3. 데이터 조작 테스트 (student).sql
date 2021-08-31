SELECT USER(), DATABASE();

SHOW tables;

desc student;

-- INSERT 
INSERT into student values(2102, '나다라', 85, 73, 90);

-- SELECT 
SELECT stdno, stdname, kor, eng, math from student;
SELECT stdno, stdname, kor, eng, math from student WHERE stdno = 2101;

-- UPDATE 
UPDATE student set kor = 90 where stdno = 2012;

UPDATE student 
   set stdname = '나다라', kor = 91, eng = 87, math = 99
 where stdno = 2102;
 
-- DELETE 
DELETE from student where stdno = 2102;