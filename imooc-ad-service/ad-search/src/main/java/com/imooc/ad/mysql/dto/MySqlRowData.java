package com.imooc.ad.mysql.dto;

import com.imooc.ad.mysql.constant.OpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class MySqlRowData {

    private String tableName;

    private String level;

    private OpType opType;

    private List<Map<String, String>> fieldValueMap = new ArrayList<>();
}
