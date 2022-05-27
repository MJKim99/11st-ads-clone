//package com.eleven.board.repository;
//
//import com.eleven.board.domain.ManageAd;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.data.jdbc.repository.query.Modifying;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ManageRepository extends JpaRepository<ManageAd, Integer> {
//
//    List<ManageAd> findAll();
//    ManageAd findByUid(int uid);
//    ManageAd save(ManageAd manageAd);
//    @Modifying
//    @Query("update ManageAd a set a.category = :category, a.subCate = :subCate, a.content = :content where a.uid = :uid")
//    int setFixedAdFor(@Param("category") String category, @Param("subCate") String subCate, @Param("content") String content, @Param("uid") int uid);
//    int deleteByUid(int uid);
//}
