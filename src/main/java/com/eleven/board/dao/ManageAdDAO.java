package com.eleven.board.dao;

import com.eleven.board.domain.ManageAd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManageAdDAO {

    public List<ManageAd> manageAdList(@Param("category") String category, @Param("searchWord") String searchWord
                                       ,@Param("start") int start, @Param("end") int end); //글 전체 목록
    public int getTotal();
    public int getSearchTotal(@Param("searchWord") String searchWord);
    public ManageAd selectByUid(int uid); //특정 글
    public int insertAd(ManageAd dto);
    public int updateAd(ManageAd dto);
    public int deleteByUid(int uid);
}
