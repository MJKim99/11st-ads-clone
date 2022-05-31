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
        List<ManageAd> adList =manageAdDAO.manageAdList(null, paging.getSearchWord(), paging.getStart(), paging.getEnd());
        String category = null;
        String subCate = null;

        for (ManageAd ad: adList) {
            category = ad.getCategory();
            subCate = ad.getSubCate();

            switch (category) {
                case "01":
                    category = "공통";
                    break;
                case "02":
                    category = "포커스클릭";
                    break;
                case "03":
                    category = "브랜딩광고";
                    break;
                case "04":
                    category = "전시입찰광고";
                    break;
                case "05":
                    category = "리스팅광고";
                    break;
                case "06":
                    category = "오늘의PICK";
                    break;
                default:
                    break;
            }

            switch (subCate) {
                case "01":
                    subCate = "교육";
                    break;
                case "02":
                    subCate = "마케팅";
                    break;
                case "03":
                    subCate = "상품";
                    break;
                case "04":
                    subCate = "플랫폼";
                    break;
                case "05":
                    subCate = "약관";
                    break;
                case "06":
                    subCate = "기타";
                    break;
                default:
                    break;
            }

            ad.setCategory(category);
            ad.setSubCate(subCate);
        }

        return adList;
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
