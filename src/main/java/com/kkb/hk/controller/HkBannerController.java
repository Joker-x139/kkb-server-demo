package com.kkb.hk.controller;

import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.utils.DateUtils;
import com.kkb.hk.utils.ReqResultUtil;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @className HkBannerController
 * @description:banner接口层
 * @author Allen
 * @date 2021/12/16 15:48
 */
@RestController
@RequestMapping("hkBanner")
@Slf4j
public class HkBannerController {


    @Resource
    private HkBannerService hkBannerService;

    /**
     * @description:  查询banner列表
     * @param: []
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     * @author Allen
     * @date: 2021/12/16 15:48
     */
    @RequestMapping(value = "/qryList", method = RequestMethod.POST)
    public ResponseEntity<String> qryList(HkBannerRequest hkBannerRequest) {
        log.info("进入banner列表接口");
        log.info("开始");
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.qryList(hkBannerRequest));
    }

    /**
     * @description:分页查询banner列表
     * @param: [hkBannerRequest]
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     * @author Allen
     * @date: 2021/12/16 18:53
     */
    @RequestMapping(value = "/qryListByPage", method = RequestMethod.POST)
    public ResponseEntity<String> qryListByPage(HkBannerRequest hkBannerRequest) {
        log.info("进入banner列表接口");
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.qryListByPage(hkBannerRequest));
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<String> add(HkBanner hkBanner){
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.addBanner(hkBanner));
    }

    /**
     * @Description: 通过id查询单个banner
     * @Param: [id]
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     * @Author: Joker
     * @Date: 2021/12/21 12:54
     */
    @RequestMapping(value = "/banner/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<String> qryById(@PathVariable Integer id){
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.qryBannerById(id));
    }

    /**
     * @Description: 通过id删除banner
     * @Param: [id]
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     * @Author: Joker
     * @Date: 2021/12/21 12:55
     */
    @RequestMapping(value = "/banner/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delById(@PathVariable Integer id){
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.delBannerById(id));
    }


}

