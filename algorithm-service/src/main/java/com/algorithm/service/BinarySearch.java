package com.algorithm.service;

import com.algorithm.common.enums.SysExpEnum;
import com.algorithm.common.exceptions.AlgorithmException;

import java.util.List;

/**
 * 二分查找法
 * 时间复杂度为log(N)
 * 针对有序集合
 * User: lijinpeng
 * Created by Shanghai on 2019/5/12.
 */
public class BinarySearch {
    /**
     * 二分查找法
     *
     * @param dataList 待排序数据
     * @param data     要查找的数据
     * @return 返回集合中的位置
     */
    public static int binarySearch(List<Integer> dataList, Integer data) throws AlgorithmException {
        System.out.println("目标集合:" + dataList + "  目标值:" + data);
        int low = 0;
        int high = dataList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data == dataList.get(mid)) {
                System.out.println("目标值在数组的下标索引为:" + mid);
                return mid;
            } else if (data > dataList.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("在集合中未找到该数据:" + data);
        throw new AlgorithmException(SysExpEnum.DATA_NOT_FIND);
    }
}
