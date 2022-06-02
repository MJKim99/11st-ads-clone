package com.eleven.board.paging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class Paging {

    /**
     * prev: 이전 페이지 확인용
     * next: 다음 페이지 확인용
     * startPage: 시작 페이지
     * endPage: 끝 페이지
     * totalRecord: 전체 데이터 개수
     * totalPage: 전체 페이지 수
     * page: 현재 페이지
     * start, end: DB에서 가져올 데이터 처음부터 끝
     * listSize: 현재 페이지에서 보여질 글 개수
     * range: 페이지 범위 (1~10인 경우 10)
     *
     * searchWord: 검색 키워드
     */
    private boolean prev, next;
    private int startPage, endPage, totalRecord, totalPage, page, start, end;
    private int listSize = 5, range = 5;
    private String searchWord;

    public Paging(int totalRecord, int page) {
        this.page = page;
        this.totalRecord = totalRecord;
        initPaging();
    }

    public Paging(int totalRecord, int page, String searchWord) {
        this.page = page;
        this.totalRecord = totalRecord;
        this.searchWord = searchWord;
        initPaging();
    }

    public void initPaging() {
        //마지막 페이지, 전체 페이지 중 마지막 페이지 계산
        endPage = (int) (Math.ceil(page / (double) range)) * range;

        totalPage = (int) (Math.ceil((double) totalRecord / range));
        if (endPage > totalPage) {
            endPage = totalPage;
        }
        
        //시작 페이지 계산
        startPage = endPage - range + 1;
        if (startPage < 0) {
            startPage = 1;
        }

        //limit #{start}, #{end}
        end = page * range;
        start = end - range;

        //<, > 표시
        prev = startPage > 1; //시작 페이지가 1보다 큰 경우
        next = endPage < totalPage; //현재 마지막 페이지보다 전체 마지막 페이지가 큰 경우
    }

}
