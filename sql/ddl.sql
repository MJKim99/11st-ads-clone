create table ads_manage (
  uid int not null auto_increment, -- uid
  category varchar(30) not null, -- (공통/포커스클릭/브랜딩광고/...)
  sub_cate varchar(20) not null, -- 구분
  title varchar(100) not null, -- 제목
  content text, -- 내용
  regdate date default (current_date), -- 등록일자
  constraint pk_ads_manage primary key(uid)
);