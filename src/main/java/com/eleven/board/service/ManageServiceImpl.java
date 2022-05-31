package com.eleven.board.service;

import com.eleven.board.dao.ManageAdDAO;
import com.eleven.board.domain.ManageAd;
import com.eleven.board.paging.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManageServiceImpl implements ManageService {

    private final ManageAdDAO manageAdDAO;
//    private final ManageRepository manageRepository;

    @Autowired
    public ManageServiceImpl(ManageAdDAO manageAdDAO) {
        this.manageAdDAO = manageAdDAO;
//        this.manageRepository = manageRepository;
    }

    @Override
    public int getTotal() {
        return manageAdDAO.getTotal();
    }

    @Override
    public int getSearchTotal(String searchWord) {
        return manageAdDAO.getSearchTotal(searchWord);
    }

    @Override
    public List<ManageAd> manageAdList(Paging paging/*String category*/) {
        return manageAdDAO.manageAdList(null, paging.getSearchWord(), paging.getStart(), paging.getEnd());
//        return manageRepository.findAll();
    }

    @Override
    public ManageAd viewAd(int uid) {
        return manageAdDAO.selectByUid(uid);
//        return manageRepository.findByUid(uid);
    }

    @Override
    public int writeAd(ManageAd ad) {
        return manageAdDAO.insertAd(ad);
//        return manageRepository.save(ad);
    }

    @Override
    public int updateAd(ManageAd ad) {
        return manageAdDAO.updateAd(ad);
//        return manageRepository.setFixedAdFor(ad.getCategory(), ad.getSubCate(), ad.getContent(), ad.getUid());
    }

    @Override
    public int deleteAd(int uid) {
        return manageAdDAO.deleteByUid(uid);
//        return manageRepository.deleteByUid(uid);
    }
}
