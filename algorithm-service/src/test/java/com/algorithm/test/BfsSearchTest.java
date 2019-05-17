package com.algorithm.test;

import com.algorithm.service.BfsSearchAlg;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Created by lijinpeng on 2019/5/17.
 */
@Slf4j
public class BfsSearchTest {

    private Map<String,List<String>> dataMap;

    @Before
    public void init()
    {
        dataMap=new HashMap<String, List<String>>();
        dataMap.put("zhengzhou", Arrays.asList("wuhan","hefei","beijing"));
        dataMap.put("wuhan", Arrays.asList("nanjing","suzhou","beijing"));
        dataMap.put("hefei", Arrays.asList("nanjing","shanghai"));
        dataMap.put("beijing", Arrays.asList("nanjing","shanghai","wuhan"));
        dataMap.put("nanjing", Arrays.asList("shanghai"));
        dataMap.put("suzhou", Arrays.asList("shanghai"));
    }

    @Test
    public void bfsSearchTest()
    {
        boolean way = BfsSearchAlg.bfsSearch(dataMap, "zhengzhou", "shanghai");
        log.info("是否存在路径:{}",way);
    }

}

