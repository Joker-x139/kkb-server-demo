package com.kkb.hk.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.hk.dao.HkBannerDao;
import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.entity.page.PageResult;
import com.kkb.hk.entity.reqresult.ReqResult;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.utils.DateUtils;
import com.kkb.hk.utils.PageUtils;
import com.kkb.hk.utils.StringUtils;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @className HkBannerServiceImpl
 * @description:  banner表(HkBanner)表服务实现类
 * @author Allen
 * @date 2021/12/16 15:57
 */
@Service("hkBannerService")
public class HkBannerServiceImpl implements HkBannerService {
    @Resource
    private HkBannerDao hkBannerDao;

    /**
     * @description:  查询banner列表
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 19:29
     */
    @Override
    public List<HkBannerResponse> qryList(HkBannerRequest hkBannerRequest) {
        //此处代码需要先从redis中获取，获取不到则取查数据库
        String historyJsON = null;

        if (StringUtils.isEmpty(historyJsON)) {
            //缓存中没有数据，查询数据库
            List<HkBannerResponse> list = hkBannerDao.qryList(hkBannerRequest);
            //此处代码需要把查出来的结果set redis缓存
            return list;
        }
        List<HkBannerResponse> list = JSON.parseObject(historyJsON, new TypeReference<List<HkBannerResponse>>() {});
        return list;
    }


    /**
     * @description:  查询banner列表分页查询
     * @param: [hkBannerRequest]
     * @return: com.kkb.hk.entity.page.PageResult
     * @author Allen
     * @date: 2021/12/16 17:48
     */

    @Override
    public PageResult qryListByPage(HkBannerRequest hkBannerRequest) {
        int pageNum = hkBannerRequest.getPageNum();
        int pageSize = hkBannerRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<HkBannerResponse> responseList = this.hkBannerDao.qryListByPage(hkBannerRequest);
        return PageUtils.getPageResult(new PageInfo<HkBannerResponse>(responseList));
    }

    /**
     * @Description: 向banner中添加信息
     * @Param: [hkBanner]
     * @return: com.kkb.hk.entity.reqresult.ReqResult
     * @Author: Joker
     * @Date: 2021/12/20 18:22
     */
    @Override
    public ReqResult addBanner(HkBanner hkBanner) {
        Date nowDate = DateUtils.getNowDate();
        System.out.println(nowDate);
        hkBanner.setCreatedTime(nowDate);
        hkBannerDao.insertHkBanner(hkBanner);

        return new ReqResult(1000);
    }

    /**
     * @Description: 通过id删除banner数据
     * @Param: [id]
     * @return: com.kkb.hk.entity.reqresult.ReqResult
     * @Author: Joker
     * @Date: 2021/12/20 20:12
     */
    @Override
    public ReqResult delBannerById(Integer id) {
        int i = hkBannerDao.delBannerById(id);
        if(i>0){
            return new ReqResult(1000);
        }
        return new ReqResult(9999,"操作失败！要删除的数据不存在！");
    }

    /**
     * @Description: 通过id查询banner
     * @Param: [id]
     * @return: com.kkb.hk.vo.response.banner.HkBannerResponse
     * @Author: Joker
     * @Date: 2021/12/20 20:54
     */
    @Override
    public HkBannerResponse qryBannerById(Integer id) {
        HkBannerResponse banner = hkBannerDao.qryBannerById(id);
        return banner;
    }

    /**
     * @Description: 查询所有未被删除的banner
     * @Param: []
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @Author: Joker
     * @Date: 2021/12/21 13:10
     */
    @Override
    public List<HkBannerResponse> qryBannerList() {
        List<HkBannerResponse> list = hkBannerDao.qryBannerList();
        return list;
    }

    /**
     * @Description: 通过id找到要修改的数据并进行修改
     * @Param: [hkBanner]
     * @return: com.kkb.hk.vo.response.banner.HkBannerResponse
     * @Author: Joker
     * @Date: 2021/12/21 13:31
     */
    @Override
    public ReqResult update(HkBanner hkBanner) {
        Date nowDate = DateUtils.getNowDate();
        hkBanner.setUpdatedTime(nowDate);
        int i = hkBannerDao.update(hkBanner);
        if(i>0){
            return new ReqResult(1000);
        }
        return new ReqResult(9999,"修改失败！请确保输入了正确的id");
    }

}
