package com.algorithm.common.exceptions;

import com.algorithm.common.enums.SysExpEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统处理异常类
 * User: lijinpeng
 * Created by Shanghai on 2019/5/12.
 */
@Setter
@Getter
public class AlgorithmException extends Exception {
    private String errorCode;
    private String errorMsg;

    public AlgorithmException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AlgorithmException(SysExpEnum exception) {
        errorCode = exception.getErrorCode();
        errorMsg = exception.getErrorMsg();
    }
}
