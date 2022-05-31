package com.eleven.board.controller;

import com.eleven.board.domain.ManageAd;
import com.eleven.board.paging.Paging;
import com.eleven.board.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    private final ManageService manageService;

    @Autowired
    public ManageController(ManageService manageService) {
        this.manageService = manageService;
    }

    @RequestMapping("list")
    public String adList(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page
            , @RequestParam(value = "searchWord", required = false) String searchWord) {
        Paging paging;
        if (searchWord == null || ("").equals(searchWord)) {
            paging = new Paging(manageService.getTotal(), page);
        } else {
            paging = new Paging(manageService.getSearchTotal(searchWord), page, searchWord);
        }

        System.out.println("paging: " + paging.toString());

        model.addAttribute("list", manageService.manageAdList(paging));
        model.addAttribute("paging", paging);
        return "manage/adList";
    }

    @RequestMapping("view")
    public String viewAd(Model model, int uid
            , @RequestParam(value = "page", required = false, defaultValue = "1") int page
            , @RequestParam(value = "searchWord", required = false) String searchWord) {
        model.addAttribute("ad", manageService.viewAd(uid));
        model.addAttribute("page", page);
        model.addAttribute("searchWord", searchWord);
        return "manage/viewAd";
    }

    @RequestMapping("write")
    public String write() {
        return "manage/write";
    }


    @PostMapping("writeOk")
    public String writeOk(Model model, ManageAd ad) {
//        ManageAd rsAd = manageService.writeAd(ad);
        model.addAttribute("result", manageService.writeAd(ad));
        model.addAttribute("uid", ad.getUid());
        return "manage/writeOk";
    }

    @RequestMapping("update")
    public String update(Model model, int uid) {
        model.addAttribute("ad", manageService.viewAd(uid));
        return "manage/update";
    }

    @PostMapping("updateOk")
    public String updateOk(Model model, ManageAd ad) {
        model.addAttribute("result", manageService.updateAd(ad));
        model.addAttribute("uid", ad.getUid());
        return "manage/updateOk";
    }

    @RequestMapping("deleteOk")
    public String delete(Model model, int uid) {
        model.addAttribute("result", manageService.deleteAd(uid));
        return "manage/deleteOk";
    }

}
