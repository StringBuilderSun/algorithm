package com.algorithm.service;

import com.algorithm.common.model.BalanceLoadModel;
import com.sun.deploy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 基于Randoms+权重值算法
 * Created by lijinpeng on 2019/5/16.
 */
@Slf4j
public class RandomLoadSelect {

    /**
     * @param linesConfig line20=url1|line30=url2
     * @param loadConfig  line20=80|line30=20
     * @return
     */
    public static String getBanlaceLoadSeed(String linesConfig, String loadConfig) {
        try {
            //获取权重值
            int totalWeight = 0;
            //拆分成 {"line20=80","line30=20"}
            String[] line_Loads = StringUtils.splitString(loadConfig, "|");
            //拆分成{"line10=url1","line20=url2"}
            String[] line_Configs = StringUtils.splitString(linesConfig, "|");
            //如果专线权重值不为0  放入可用专线集合中 供选择
            List<BalanceLoadModel> avaliableLines = new ArrayList<BalanceLoadModel>();
            //计算专线总权重值 并且挑选权重值不为0的专线以供选择
            for (String lineLoad : line_Loads) {
                String[] lineBalances = StringUtils.splitString(lineLoad, "=");
                int loadValue = Integer.valueOf(lineBalances[1]);
                if (loadValue != 0) {
                    //如果权重值不为0  查找 该专线地址
                    for (String lineConfig : line_Configs) {
                        String[] lineInfos = StringUtils.splitString(lineConfig, "=");
                        if (lineBalances[0].equals(lineInfos[0])) {
                            BalanceLoadModel balanceLoad = new BalanceLoadModel();
                            balanceLoad.setKey(lineInfos[0]);
                            balanceLoad.setLoadValue(loadValue);
                            balanceLoad.setTargetValue(lineInfos[1]);
                            avaliableLines.add(balanceLoad);
                            totalWeight += loadValue;
                            break;
                        }
                    }
                }
            }
            log.info("待选专线集合:{} 负载总权重值:{}", avaliableLines, totalWeight);
            Random random = new Random();
            int pickSeed = 0;
            //关键条件  首先生成在总权重值范围内的 随机数 作为seed
            int randomSeed = random.nextInt(totalWeight);
            for (BalanceLoadModel balanceLoadModel : avaliableLines) {
                //遍历所有专线
                if (pickSeed <= randomSeed && randomSeed < (pickSeed + balanceLoadModel.getLoadValue())) {
                    return balanceLoadModel.getTargetValue();
                }
                //上一条专线不符合  需要累加上一条专线的权重值 作为下一次筛选条件
                pickSeed += balanceLoadModel.getLoadValue();
            }
        } catch (Exception ex) {
            log.error("专线负载匹配失败！", ex);
        }
        //匹配失败 返回第一条专线
        return StringUtils.splitString(linesConfig, "|")[0].split("=")[1];
    }
}
