package com.algorithm.test;

import com.algorithm.service.SelectSortAlg;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 选择排序测试
 * Created by lijinpeng on 2019/5/16.
 */
@Slf4j
public class SelectSortAlgTest {


    private List<Integer> sortList;

    @Before
    public void initData() {
        sortList = new ArrayList<Integer>(1000);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            sortList.add(random.nextInt(2000));
        }
    }

    @Test
    public void selectSortTest() {
        log.info("排序前的集合:{}",sortList);
        long startTime=System.currentTimeMillis();
        List<Integer> sortedList = SelectSortAlg.selectSort(sortList);
        log.info("排序后的集合:{}",sortedList);
        log.info("快速排序耗时:{}",System.currentTimeMillis()-startTime);

    }
    @Test
    public void selectSortByFindMinValueTest() {
        log.info("排序前的集合:{}",sortList);
        long startTime=System.currentTimeMillis();
        List<Integer> sortedList = SelectSortAlg.selectSortByFindMinValue(sortList);
        log.info("排序后的集合:{}",sortedList);
        log.info("快速排序耗时:{}",System.currentTimeMillis()-startTime);

    }
}
