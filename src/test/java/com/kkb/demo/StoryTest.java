package com.kkb.demo;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.kkb.hk.DemoApplication;
import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.entity.reqresult.ReqResult;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.utils.DateUtils;
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

    @Test
    public void test1() {
        HkBanner hkBanner = new HkBanner(null,"aaa","bbb","asdfa",
                "image",null,null,null, DateUtils.getNowDate(),null,null);
        System.out.println("hkbanner====================="+hkBanner);
        ReqResult add = hkBannerService.add(hkBanner);
        System.out.println(add.getData());
        System.out.println(add.getMsg());
        System.out.println(add);
    }


    @Test
    public void testqry(){
//        hkBannerService.qryList();
    }

}
