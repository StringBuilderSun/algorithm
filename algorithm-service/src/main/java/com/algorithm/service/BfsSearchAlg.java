package com.algorithm.service;

import com.algorithm.model.BfsNode;
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
    public static boolean bfsSearch(Map<String, List<String>> nodes, String startNodeValue, String endNodeValue) {
        //队列用于所有节点
        Queue<BfsNode> queue = new ArrayDeque<BfsNode>();
        queue.add(new BfsNode(null, startNodeValue));
        //获取当前节点的所有邻居节点
        //所有检查过的元素都放入到该集合中 防止再次检查 导致死循环
        List<String> checkedData = new ArrayList<String>();
        while (queue.size() != 0) {
            BfsNode bfsNode = queue.poll();
            //当节点没有被检查过的时候 才会再次检查 防止无限循环
            if (!checkedData.contains(bfsNode.getNodeValue())) {
                checkedData.add(bfsNode.getNodeValue());
                if (suitCase(bfsNode.getNodeValue(), endNodeValue)) {
                    log.info("找到了从:{} 到 {} 的路径", startNodeValue, endNodeValue);
                    log.info("最优路径为:{}",bfsNode.toString());
                    return true;
                } else {
                    addNodes(queue, nodes.get(bfsNode.getNodeValue()), bfsNode);
                }
            }
        }
        return false;
    }

    /**
     * 将邻居node添加到 栈中
     * @param queue
     * @param nextNodes
     * @param parentBfsNode
     * @return
     */
    private static Queue<BfsNode> addNodes(Queue<BfsNode> queue, List<String> nextNodes, BfsNode parentBfsNode) {
        if (nextNodes != null) {
            for (String nodeValue : nextNodes) {
                queue.add(new BfsNode(parentBfsNode, nodeValue));
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

    /**
     * 打印路径
     *
     * @return
     */
    private static String printWay(BfsNode bfsNode, String startNode) {
        StringBuilder stringBuilder = new StringBuilder(startNode);
        if (bfsNode != null) {
            while (bfsNode.getParentBfsNode() != null) {
                bfsNode = bfsNode.getParentBfsNode();
            }
            while (bfsNode.getParentBfsNode() == null) {
                stringBuilder.append("->").append(bfsNode.getNodeValue());
                bfsNode = bfsNode.getParentBfsNode();
            }
        }
        return stringBuilder.toString();

    }
}
