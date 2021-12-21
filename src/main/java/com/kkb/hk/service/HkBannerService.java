package com.kkb.hk.service;

import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.entity.page.PageResult;
import com.kkb.hk.entity.reqresult.ReqResult;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;

import java.util.List;

/**
 * @className HkBannerService
 * @description:  表(HkBanner)表服务接口
 * @author Allen
 * @date 2021/12/16 15:56
 */
public interface HkBannerService {

    /**
     * @description:  查询banner列表
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 16:23
     */
    List<HkBannerResponse> qryList(HkBannerRequest hkBannerRequest);

    /**
     * @description:  查询banner列表分页查询
     * @param: [hkBannerRequest]
     * @return: com.kkb.hk.entity.page.PageResult
     * @author Allen
     * @date: 2021/12/16 16:23
     */
    PageResult qryListByPage(HkBannerRequest hkBannerRequest);

    /**
     * @Description: 像banner中添加信息
     * @Param: [hkBanner]
     * @return: com.kkb.hk.entity.reqresult.ReqResult
     * @Author: Joker
     * @Date: 2021/12/20 18:22
     */
    ReqResult addBanner(HkBanner hkBanner);

    /**
     * @Description: 通过Id删除banner
     * @Param: [id]
     * @return: com.kkb.hk.entity.reqresult.ReqResult
     * @Author: Joker
     * @Date: 2021/12/20 19:52
     */
    ReqResult delBannerById(Integer id);

    /**
     * @Description: 通过id查询banner
     * @Param: [id]
     * @return: com.kkb.hk.vo.response.banner.HkBannerResponse
     * @Author: Joker
     * @Date: 2021/12/20 20:54
     */
    HkBannerResponse qryBannerById(Integer id);

    /**
     * @Description: 查询所有未被删除的banner
     * @Param: []
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @Author: Joker
     * @Date: 2021/12/21 13:10
     */
    List<HkBannerResponse> qryBannerList();

    /**
     * @Description: 通过id找到要修改的数据并进行修改
     * @Param: [hkBanner]
     * @return: com.kkb.hk.vo.response.banner.HkBannerResponse
     * @Author: Joker
     * @Date: 2021/12/21 13:14
     */
    ReqResult update(HkBanner hkBanner);
}
