package com.algorithm.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lijinpeng on 2019/5/16.
 */
@Setter
@Getter
@ToString
public class BalanceLoadModel{

    /**
     * 前缀值
     */
    private String key;

    /**
     * 负载值
     */
    private int loadValue;

    /**
     * 目标值
     */
    private String targetValue;

}
