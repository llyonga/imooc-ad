package com.imooc.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019/10/25
 * @time: 11:14 上午
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geo {

    private Float latitude;
    private Float longitude;

    private String city;
    private String province;
}
