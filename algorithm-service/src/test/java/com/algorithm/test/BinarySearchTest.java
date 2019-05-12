package com.algorithm.test;

import com.algorithm.common.exceptions.AlgorithmException;
import com.algorithm.service.BinarySearch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 二分查找测试类
 * User: lijinpeng
 * Created by Shanghai on 2019/5/12.
 */
public class BinarySearchTest {

    private List<Integer> dataList = new ArrayList<Integer>();

    public Integer initData(int size) {
        Integer targetValue;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            dataList.add(random.nextInt(1000));
        }
        targetValue = dataList.get(random.nextInt(size + 1));
        dataList.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return targetValue;
    }

    @Test
    public void binarySearchTest() throws AlgorithmException {
        Integer targetValue = initData(301);
        BinarySearch.binarySearch(dataList, targetValue);
    }
}
