package com.eleven.board.service;

import com.eleven.board.domain.ManageAd;
import com.eleven.board.paging.Paging;

import java.util.List;

public interface ManageService {

    public List<ManageAd> manageAdList(Paging paging/*String category*/);
    public int getTotal();
    public int getSearchTotal(String searchWord);
    public ManageAd viewAd(int uid);
    public int writeAd(ManageAd dto);
    public int updateAd(ManageAd dto);
    public int deleteAd(int uid);

}
