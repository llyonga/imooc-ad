package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019/10/24
 * @time: 3:35 下午
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitKeywordTable {

    private Long unitId;
    private String keyword;
}
