create database chan;

-- 회원정보
CREATE TABLE `chan`.`tbl_member` (
	`member_id`   VARCHAR(40) NOT NULL COMMENT '아이디/이메일', -- 아이디/이메일
	`member_pwd`  varchar(40) NOT NULL COMMENT '패스워드', -- 패스워드
	`regist_date` DATE        NOT NULL COMMENT '회원가입일자' -- 회원가입일자
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE `chan`.`tbl_member`
	ADD CONSTRAINT `PK_tbl_member` -- 회원정보 기본키
		PRIMARY KEY (
			`member_id` -- 아이디/이메일
		);   

-- 비교품목
CREATE TABLE `chan`.`tbl_item` (
	`item_id`    INT(11)      NOT NULL COMMENT '품명아이디', -- 품명아이디
	`item_name`  varchar(100) NOT NULL COMMENT '품명', -- 품명
	`image_path` varchar(100) NOT NULL COMMENT '이미지' -- 이미지
)
COMMENT '비교품목';

-- 비교품목
ALTER TABLE `chan`.`tbl_item`
	ADD CONSTRAINT `PK_tbl_item` -- 비교품목 기본키
		PRIMARY KEY (
			`item_id` -- 품명아이디
		);

ALTER TABLE `tbl_item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT;

-- 가격정보
CREATE TABLE `chan`.`tbl_crawling` (
	`crawling_id`    INT(11) NOT NULL COMMENT '가격정보아이디', -- 가격정보아이디
	`item_id`        INT(11) NULL     COMMENT '품명아이디', -- 품명아이디
	`site_id`        INT(11) NULL     COMMENT '사이트아이디', -- 사이트아이디
	`crawling_time`  DATE    NULL     COMMENT '일시', -- 일시
	`crawling_price` DOUBLE  NULL     COMMENT '가격' -- 가격
)
COMMENT '가격정보';

-- 가격정보
ALTER TABLE `chan`.`tbl_crawling`
	ADD CONSTRAINT `PK_tbl_crawling` -- 가격정보 기본키
		PRIMARY KEY (
			`crawling_id` -- 가격정보아이디
		);

ALTER TABLE `tbl_crawling`
  MODIFY `crawling_id` int(11) NOT NULL AUTO_INCREMENT;

-- 비교사이트
CREATE TABLE `chan`.`tbl_site` (
	`site_id`    INT(11)      NOT NULL COMMENT '사이트아이디', -- 사이트아이디
	`site_name` VARCHAR(100) NOT NULL COMMENT '사이트명' -- 사이트명
)
COMMENT '비교사이트';

-- 비교사이트
ALTER TABLE `chan`.`tbl_site`
	ADD CONSTRAINT `PK_tbl_site` -- 비교사이트 기본키
		PRIMARY KEY (
			`site_id` -- 사이트아이디
		);

ALTER TABLE `tbl_site`
  MODIFY `site_id` int(11) NOT NULL AUTO_INCREMENT;

-- 건의게시판
CREATE TABLE `chan`.`tbl_board` (
	`board_id`    INT(11)      NOT NULL COMMENT '게시판아이디', -- 게시판아이디
	`subject`     varchar(100) NULL     COMMENT '제목', -- 제목
	`content`     TEXT         NULL     COMMENT '내용', -- 내용
	`regist_date` DATE         NULL     COMMENT '작성일자', -- 작성일자
	`del_yn`      char(1)      NULL     COMMENT '삭제여부', -- 삭제여부
	`recommand`   INT(2)       NULL     COMMENT '추천', -- 추천
	`member_id`   VARCHAR(40)  NULL     COMMENT '아이디/이메일' -- 아이디/이메일
)
COMMENT '건의게시판';

-- 건의게시판
ALTER TABLE `chan`.`tbl_board`
	ADD CONSTRAINT `PK_tbl_board` -- 건의게시판 기본키
		PRIMARY KEY (
			`board_id` -- 게시판아이디
		);

-- 북마크
CREATE TABLE `chan`.`tbl_bookmark` (
	`bookmark_id`   INT(11)      NULL COMMENT '북마크아이디', -- 북마크아이디
	`bookmark_name` VARCHAR(100) NULL COMMENT '사용자 정의 북마크', -- 사용자 정의 북마크
	`crawling_id`   INT(11)      NULL COMMENT '가격정보아이디', -- 가격정보아이디
	`member_id`     VARCHAR(40)  NULL COMMENT '아이디/이메일' -- 아이디/이메일
)
COMMENT '북마크';

-- 가격정보
ALTER TABLE `chan`.`tbl_crawling`
	ADD CONSTRAINT `FK_tbl_item_TO_tbl_crawling` -- 비교품목 -> 가격정보
		FOREIGN KEY (
			`item_id` -- 품명아이디
		)
		REFERENCES `chan`.`tbl_item` ( -- 비교품목
			`item_id` -- 품명아이디
		);

-- 가격정보
ALTER TABLE `chan`.`tbl_crawling`
	ADD CONSTRAINT `FK_tbl_site_TO_tbl_crawling` -- 비교사이트 -> 가격정보
		FOREIGN KEY (
			`site_id` -- 사이트아이디
		)
		REFERENCES `chan`.`tbl_site` ( -- 비교사이트
			`site_id` -- 사이트아이디
		);

-- 건의게시판
ALTER TABLE `chan`.`tbl_board`
	ADD CONSTRAINT `FK_tbl_member_TO_tbl_board` -- 회원정보 -> 건의게시판
		FOREIGN KEY (
			`member_id` -- 아이디/이메일
		)
		REFERENCES `chan`.`tbl_member` ( -- 회원정보
			`member_id` -- 아이디/이메일
		);

-- 북마크
ALTER TABLE `chan`.`tbl_bookmark`
	ADD CONSTRAINT `FK_tbl_crawling_TO_tbl_bookmark` -- 가격정보 -> 북마크
		FOREIGN KEY (
			`crawling_id` -- 가격정보아이디
		)
		REFERENCES `chan`.`tbl_crawling` ( -- 가격정보
			`crawling_id` -- 가격정보아이디
		);

-- 북마크
ALTER TABLE `chan`.`tbl_bookmark`
	ADD CONSTRAINT `FK_tbl_member_TO_tbl_bookmark` -- 회원정보 -> 북마크
		FOREIGN KEY (
			`member_id` -- 아이디/이메일
		)
		REFERENCES `chan`.`tbl_member` ( -- 회원정보
			`member_id` -- 아이디/이메일
		);
