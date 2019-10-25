package com.imooc.ad.sender;

import com.imooc.ad.mysql.dto.MySqlRowData;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019/10/25
 * @time: 11:14 上午
 * @version: 1.0
 */
public interface ISender {

    void sender(MySqlRowData rowData);
}
