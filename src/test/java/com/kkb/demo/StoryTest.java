package com.kkb.demo;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.kkb.hk.DemoApplication;
import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.entity.reqresult.ReqResult;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.utils.DateUtils;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

/**
 * @Description
 * @Date 2021/9/25 9:27
 * @Created 30500
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class StoryTest {
    @Autowired
    HkBannerService hkBannerService;

    /**
     * @Description: 测试添加接口
     * @Param: []
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/21 13:51
     */
    @Test
    public void testAdd() {
        HkBanner hkBanner = new HkBanner(null,"啊啊啊","OAOA","图片2",
                "abcde",null,null,"Joker", DateUtils.getNowDate(),null,null);
        System.out.println("hkbanner====================="+hkBanner);
        ReqResult add = hkBannerService.addBanner(hkBanner);
        System.out.println(add.getData());
        System.out.println(add.getMsg());
        System.out.println(add);
    }

    /**
     * @Description: 测试查询列表接口
     * @Param: []
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/21 13:52
     */
    @Test
    public void testqryList(){
        HkBannerRequest hkBannerRequest = new HkBannerRequest(null);
        List<HkBannerResponse> hkBannerResponses = hkBannerService.qryList(hkBannerRequest);
        for (HkBannerResponse hkBannerRespons : hkBannerResponses) {
            System.out.println(hkBannerRespons);
        }
    }

    /**
     * @Description: 测试删除接口
     * @Param: []
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/21 13:52
     */
    @Test
    public void testDel(){
        Integer id = 20;
        ReqResult reqResult = hkBannerService.delBannerById(id);
        System.out.println(reqResult.getCode());
        System.out.println(reqResult.getMsg());
    }

    /**
     * @Description: 测试通过id查询接口
     * @Param: []
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/21 13:53
     */
    @Test
    public void testQryBannerById(){
        Integer id = 10;
        HkBannerResponse banner = hkBannerService.qryBannerById(id);
        System.out.println(banner);
    }

    /**
     * @Description: 测试修改接口
     * @Param: []
     * @return: void
     * @Author: Joker
     * @Date: 2021/12/21 13:53
     */
    @Test
    public void testUpdate(){
        HkBanner hkBanner = new HkBanner(4,"美女","这是一张美女图片","图片1",
                "image",0,null,null, null,"Joker",DateUtils.getNowDate());
        ReqResult update = hkBannerService.update(hkBanner);
        System.out.println(update.getMsg());
    }

}
