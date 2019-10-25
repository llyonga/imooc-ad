package com.imooc.ad.mysql.listener;

import com.imooc.ad.mysql.dto.BinlogRowData;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019/10/25
 * @time: 11:14 上午
 * @version: 1.0
 */
public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
