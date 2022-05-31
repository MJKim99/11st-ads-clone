create table ads_manage (
  uid int not null auto_increment comment 'pk', -- uid
  adm_cate_th1_cd varchar(10) not null comment '공통코드 1차', -- (공통/포커스클릭/브랜딩광고/...)
  adm_cate_th2_cd varchar(10) not null comment '공통코드 2차',
  title varchar(100) not null comment '제목',
  content text comment '내용',
  regdate date default (current_date) comment '등록일자',
  filepath varchar(100) comment '파일경로',
  constraint pk_ads_manage primary key(uid)
);

create table pc ( -- 공통코드
  grp_cd varchar(100) not null comment '그룹코드',
  cmm_cd varchar(10) not null comment '공통코드',
  cmm_cd_nm varchar(50) not null comment '공통코드명',
  cmm_cd_dscr varchar(100) not null comment '공통코드설명',
  sort_ord int comment '정렬순서',
  reg_dttm datetime default (current_time) comment '등록일시',
  upd_dttm datetime comment '수정일시',
  constraint pk_pc primary key(grp_cd, cmm_cd)
);

insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th1_cd', '01', '공통', '공통', 1);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th1_cd', '02', '포커스클릭', '포커스클릭', 2);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th1_cd', '03', '브랜딩광고', '브랜딩광고', 3);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th1_cd', '04', '전시입찰광고', '전시입찰광고', 4);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th1_cd', '05', '리스팅광고', '리스팅광고', 5);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th1_cd', '06', '오늘의PICK', '오늘의PICK', 6);

insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th2_cd', '01', '교육', '교육', 1);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th2_cd', '02', '마케팅', '마케팅', 2);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th2_cd', '03', '상품', '상품', 3);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th2_cd', '04', '플랫폼', '플랫폼', 4);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th2_cd', '05', '약관', '약관', 5);
insert into pc (grp_cd, cmm_cd, cmm_cd_nm, cmm_cd_dscr, sort_ord)
values ('adm_cate_th2_cd', '06', '기타', '기타', 6);