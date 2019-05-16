package com.algorithm.service;

/**
 * 简单递归算法
 * 给定一个数组 求数组中所有元素的和
 *递归的核心点是1、找出基性条件  2、找出线性条件
 * User: lijinpeng
 * Created by Shanghai on 2019/5/16.
 */
public class SimpleRecursiveAlg {

    public static int sum(int[] data) {
        //基性条件是 数组中元素个数<1 不需要再次计算
        if (data.length <= 1) {
            return data[0];
        } else {
            //线性条件 是  当前数组中还有多余一个元素、
            int[] newArray = new int[data.length - 1];
            System.arraycopy(data, 1, newArray, 0, data.length - 1);
            return data[0] + sum(newArray);
        }
    }

    /**
     * 黄金分割问题，给定长度 和 宽度
     * 获取将这块地规划成正方形的合适长度
     * @param length
     * @param width
     * @return
     */
    public static int split(int length, int width) {
        //基性条件是 长=宽
        if (length == width) {
            return length;
        } else {
            //线性条件是 长  宽 不同  继续分割
            if (length > width) {
                int newLength = length - width;
                return split(newLength, width);
            } else {
                int newWidth = width - length;
                return split(length, newWidth);
            }
        }
    }

}
