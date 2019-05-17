package com.algorithm.test;


import com.algorithm.service.QuickSortAlg;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * 快速排序测试案例
 * Created by lijinpeng on 2019/5/17.
 */
@Slf4j
public class QuickSortTest {

    private int[] dataList = new int[1000];

    @Before
    public void initData() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            dataList[i] = random.nextInt(2000);
        }
    }

    @Test
    public void quickSortTest() {
        log.info("快速排序前的集合:{}", dataList);
        long startTime = System.currentTimeMillis();
        QuickSortAlg.quickSort(dataList, 0, dataList.length - 1);
        log.info("快速排序后的集合:{}", dataList);
        log.info("快速排序耗时:{}", System.currentTimeMillis() - startTime);
    }

}
