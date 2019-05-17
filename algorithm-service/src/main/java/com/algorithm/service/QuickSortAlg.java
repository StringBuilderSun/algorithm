package com.algorithm.service;

/**
 * 快速排序
 * 快速查找的时间复杂度为O(N*logN)
 * 最差的情况就是 每次的基准值是最大或者最小的值，相当于冒泡排序
 * Created by lijinpeng on 2019/5/17.
 */
public class QuickSortAlg {

    //快速排序的原理 是  找出基准值，将大于基准值的放入数组的右半边
    //将小于基准值的放入数组的左半边，然后再次找出基准值 循环过程
    public  static void quickSort(int[] data, int left, int right) {
        //基准值是 从左边走过来的索引left 和  右边走过来的索引在同一为止
        if (left > right) {
            return;
        }
        //基准值定位数组第一个元素的为止
        int chooseValue = data[left];
        int i = left;
        int j = right;
        //同时比较两边数据 直到i 找到 大于基准值的为止，j找到小于基准值的为止  交换位置
        while (i < j) {
            //从右往左找到第一个小于 基准值得位置
            while (data[j] >=chooseValue && i < j) {
                j--;
            }
            //从左往右找到第一个大于基准值的位置
            while (data[i] <= chooseValue && i < j) {
                i++;
            }
            if (i < j) {
                //交换位置
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        //需要将基准值 换到 两个数组的左右比较的接头位置 即 i=j的位置
        int replaceValue = data[i];
        data[i] = chooseValue;
        //将数组中间的元素放到基准值的位置 作为下一个基准值
        data[left] = replaceValue;
        //递归排序左半边数组
        quickSort(data, left, j - 1);
        //递归排序右半边数组
        quickSort(data, j + 1, right);
    }





}
