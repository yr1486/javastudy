DROP TABLE CONTACT_TBL;
CREATE TABLE CONTACT_TBL (
	CONTACT_NO NUMBER 			 NOT NULL,
	NAME	   VARCHAR2(20 BYTE) NOT NULL,
	TEL		   VARCHAR2(20 BYTE) NULL,
	EMAIL	   VARCHAR2(99 BYTE) NULL,
	ADDRESS	   VARCHAR2(99 BYTE) NULL
);

ALTER TABLE CONTACT_TBL
	ADD CONSTRAINT PK_CONTACT PRIMARY KEY(CONTACT_NO);
	
DROP SEQUENCE COTACT_SEQ;
CREATE SEQUENCE CONTACT_SEQ NOCACHE;

-- 자바에서 실행 방법 - 오라클에서는 컨트롤엔터
-- 맨위 타입 오라클11 / 네임 GDJ61 맞추고 우클릭 execute all 누르면 실행되고, 에러창 2개 뜸 왜냐 본문에 드랍이 2개 있으니까!

SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS
  FROM CONTACT_TBL;
  

 