package com.algorithm.test;

import com.algorithm.service.SimpleRecursiveAlg;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 简单递归的验证
 * User: lijinpeng
 * Created by Shanghai on 2019/5/16.
 */
@Slf4j
public class SimpleRecursiveTest {

    @Test
    public void sumTest() {
        int[] data = {1, 10, 20, 30};
        int sum = SimpleRecursiveAlg.sum(data);
        log.info("sum:{}",sum);
    }

    @Test
    public void splitTest() {
      int length=1020;
      int width=300;
      int size= SimpleRecursiveAlg.split(length,width);
      log.info("size:{}",size);
    }
}
