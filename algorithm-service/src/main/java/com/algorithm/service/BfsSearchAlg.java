package com.algorithm.service;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

/**
 * 广度优先搜索算法
 * 用于解决两类问题
 * 1、是否有从A--Z的路线
 * 2、从A-Z的最短路径
 * 广度有限搜索是用图的概念表示的 数据结构为 一个hash表，和  一个 队列
 * hash表 存储 A 节点的所有 相邻节点，再放入到队列
 * 遍历hash表的第一层节点，如果第一层节点后还有节点 将其添加到队列
 * 队列是先进先出，所以会先遍历第一层节点 再遍历后层节点 最终找到目标 最先匹配到目标的路径就是最短路径
 * Created by lijinpeng on 2019/5/17.
 */
@Slf4j
public class BfsSearchAlg {
    //zhengzhou:{"wuhan","hefei","beijing"}};
    //wuhan:{"nanjing","suzhou","beijing"}
    //hefei:{"nanjing","shanghai"}
    //beijing:{"nanjing","shanghai","wuhan"}
    //nanjing:{"shanghai"}
    //suzhou:{"shanghai"}
    public static boolean bfsSearch(Map<String, List<String>> nodes, String startNode, String endNode) {
        //队列用于所有节点
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(startNode);
        //获取当前节点的所有邻居节点
        //所有检查过的元素都放入到该集合中 防止再次检查 导致死循环
        List<String> checkedData = new ArrayList<String>();
        while (queue.size() != 0) {
            String node = queue.poll();
            //当节点没有被检查过的时候 才会再次检查 防止无限循环
            if (!checkedData.contains(node)) {
                checkedData.add(node);
                if (suitCase(node, endNode)) {
                    log.info("找到了从:{} 到 {} 的路径", startNode, endNode);
                    return true;
                } else {
                    addNodes(queue, nodes.get(node));
                }
            }
        }
        return false;
    }


    private static Queue<String> addNodes(Queue<String> queue, List<String> nextNodes) {
        if (nextNodes != null) {
            for (String node : nextNodes) {
                queue.add(node);
            }
        }
        return queue;
    }

    /**
     * 终点条件
     *
     * @param node
     * @return
     */
    private static boolean suitCase(String node, String endNode) {
        if (endNode.equals(node)) {
            return true;
        }
        return false;
    }
}
