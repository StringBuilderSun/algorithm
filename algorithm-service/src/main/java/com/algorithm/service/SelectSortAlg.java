package com.algorithm.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择排序算法(冒泡排序)
 * 精确的时间复杂度为(n(n-1))/2
 * 由于大O表示法  通常省略常量 所以表示n*n
 * Created by lijinpeng on 2019/5/16.
 */
public class SelectSortAlg {
    /**
     * 选择排序第一种方式
     * 每趟排完后  将最大的值放到最后
     *
     * @param sortList
     * @return
     */
    public static List<Integer> selectSort(List<Integer> sortList) {

        //外层循环  控制需要排序的元素个数
        for (int i = 0; i < sortList.size(); i++) {
            //内层循环  控制当前元素需要排序的趟数
            for (int j = 0; j < sortList.size() - 1 - i; j++) {
                //如果当前元素比后面元素大  则交换为止 这样可以保证每次将最大的值排到最后
                if (sortList.get(j) > sortList.get(j + 1)) {
                    Integer localValue = sortList.get(j);
                    sortList.set(j, sortList.get(j + 1));
                    sortList.set(j + 1, localValue);
                }
            }
        }
        return sortList;
    }

    /**
     * 选择排序
     * 每次查找最小值,将最小值放入到新集合中
     * 性能更好一点
     * @param sortList
     * @return
     */
    public static List<Integer> selectSortByFindMinValue(List<Integer> sortList) {
        List<Integer> newSortList = new ArrayList<Integer>();
        int count=sortList.size();
        for (int i = 0; i < count; i++) {
            newSortList.add(findMinValueIndex(sortList));
        }
        return newSortList;
    }

    /**
     * 每次获取最小值
     * @param sortList
     * @return
     */
    public static Integer findMinValueIndex(List<Integer> sortList) {
        Integer minValue = sortList.get(sortList.size()-1);
        for (int i = sortList.size()-1; i >=0; i--) {
            if (minValue > sortList.get(i)) {
                minValue = sortList.get(i);
            }
        }
        sortList.remove(minValue);
        return minValue;
    }

}
