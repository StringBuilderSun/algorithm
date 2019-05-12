package com.algorithm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * User: lijinpeng
 * Created by Shanghai on 2019/5/12.
 */
@AllArgsConstructor
@Getter
public enum SysExpEnum {
    DATA_NOT_FIND("SYS404","未找到指定数据位置");
    private String errorCode;
    private String errorMsg;
}
