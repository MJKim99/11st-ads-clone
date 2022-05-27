package com.eleven.board.domain;

import com.eleven.board.paging.Paging;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Entity
//@Table(name="ads_manage")
public class ManageAd {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;

//    @Column(name = "category")
    private String category;

//    @Column(name = "sub_cate")
    private String subCate;

//    @Column(name = "title")
    private String title;

//    @Column(name = "content")
    private String content;

//    @Column(name = "regDate")
    private LocalDate regDate;

}