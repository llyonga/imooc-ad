package com.imooc.ad.mysql.constant;

import com.github.shyiko.mysql.binlog.event.EventType;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019/10/25
 * @time: 11:14 上午
 * @version: 1.0
 */
public enum OpType {

    ADD,
    UPDATE,
    DELETE,
    OTHER;

    public static OpType to(EventType eventType) {

        switch (eventType) {
            case EXT_WRITE_ROWS:
                return ADD;
            case EXT_UPDATE_ROWS:
                return UPDATE;
            case EXT_DELETE_ROWS:
                return DELETE;

            default:
                return OTHER;
        }
    }
}
