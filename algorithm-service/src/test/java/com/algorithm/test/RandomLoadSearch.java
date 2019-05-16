package com.algorithm.test;

import com.algorithm.service.RandomLoadSelect;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lijinpeng on 2019/5/16.
 */
@Slf4j
public class RandomLoadSearch {
    @Test
    public void searchLoadLines() {
        String linesConfig = "line10=url1|line20=url2|line30=url3|line40=url4";
        String loadConfig = "line10=10|line30=10|line40=10|line50=20";
        Map<String, Integer> sumMaps = new HashMap<String, Integer>();
        for (int i = 0; i<1000;i++) {
            String url = RandomLoadSelect.getBanlaceLoadSeed(linesConfig, loadConfig);
            AddResult(sumMaps, url);
        }
        log.info("验证结果:{}", sumMaps);
    }

    private void AddResult(Map<String, Integer> sumMaps, String url) {
        Iterator<String> iterator = sumMaps.keySet().iterator();
        while (iterator.hasNext()) {
            if (url.equals(iterator.next())) {
                sumMaps.put(url, sumMaps.get(url) + 1);
                return;
            }
        }
        sumMaps.put(url, 1);
    }
}


