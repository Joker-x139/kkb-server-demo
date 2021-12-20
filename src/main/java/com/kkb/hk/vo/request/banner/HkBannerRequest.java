package com.kkb.hk.vo.request.banner;

import com.kkb.hk.entity.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className HkBannerRequest
 * @description:banner请求参数
 * @author Allen
 * @date 2021/12/16 15:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HkBannerRequest extends PageRequest {
    /**
     * 标题
     */
    private String title;
}
