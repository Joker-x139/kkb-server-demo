package com.kkb.hk.dao;

import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @className HkBannerDao
 * @description:  表(HkBanner)表数据库访问层
 * @author Allen
 * @date 2021/12/16 15:49
 */
@Mapper
public interface HkBannerDao {

    /**
     * @description:查询banner列表
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 16:25
     */
    List<HkBannerResponse> qryList(HkBannerRequest hkBannerRequest);

    /**
     * @description:查询banner列表分页查询
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 16:27
     */
    List<HkBannerResponse> qryListByPage(HkBannerRequest hkBannerRequest);

    /**
     * @Description: 添加一条banner数据
     * @Param: [hkBanner]
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/20 18:24
     */
    void insertHkBanner(HkBanner hkBanner);

    /**
     * @Description: 从表中通过ID删除banner数据
     * @Param: [id]
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/20 20:03
     */
    int delBannerById(Integer id);
    /**
     * @Description: 通过id查询banner
     * @Param: [id]
     * @return: com.kkb.hk.vo.response.banner.HkBannerResponse
     * @Author: Joker
     * @Date: 2021/12/21 13:05
     */
    HkBannerResponse qryBannerById(Integer id);
    /**
     * @Description: 查询所有未被删除的banner
     * @Param: []
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @Author: Joker
     * @Date: 2021/12/21 13:06
     */
    List<HkBannerResponse> qryBannerList();
    /**
     * @Description: 通过id找到要修改的数据并进行修改
     * @Param: [hkBanner]
     * @return: com.kkb.hk.vo.response.banner.HkBannerResponse
     * @Author: Joker
     * @Date: 2021/12/21 13:31
     */
    int update(HkBanner hkBanner);
}

