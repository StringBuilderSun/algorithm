package com.algorithm.service;

import com.algorithm.model.DijksNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 狄克斯特拉算法
 * 求带权重值的从起点到终点的最短路径问题
 * 算法思路：
 * 1、找一个离起点最近的节点X
 * 2、计算X节点的所有邻居节点经过X到起点的距离 如果小于当前设置的距离（由于邻居节点可能不与起点相连，所以，默认设置为无限大 ），更新邻居节点到起点距离 并且更新邻居节点的父节点为当前节点
 * 3、当处理完所有X节点的邻居节点后  把 X 节点放入已处理过的节点的集合， 下次不再处理该节点
 * 4、按照上面的循环 遍历完所有节点  最终找到最短路径
 * User: lijinpeng
 * Created by Shanghai on 2019/5/18.
 */
public class DijkstraAlg {

    public static void dijkstraAlg(List<DijksNode> costs) {
        List<DijksNode> processedNodes = new ArrayList<DijksNode>();
        //当前离起点最近的节点
        DijksNode lowestNode = null;
        while ((lowestNode = getLowestCostNode(costs, processedNodes)) != null) {
            Map<DijksNode, Integer> neighbors = lowestNode.getNeighbors();
            for (DijksNode localNode : neighbors.keySet()) {
                //当前节点经过 lowestNode 节点到起点的距离
                Integer toStartDistance = lowestNode.getDistance() + neighbors.get(localNode);
                //如果经过 lowestNode 到起点距离 小于现在该元素到起点的距离  则更新当前节点
                if (toStartDistance < localNode.getDistance()) {
                    localNode.setDistance(toStartDistance);
                    //并设置当前节点的父节点是 lowestNode
                    localNode.setParentNode(lowestNode);
                }
            }
            //设置lowestNode 已经被处理过了
            processedNodes.add(lowestNode);
        }
    }

    /**
     * 找到离起点开销的节点
     *
     * @param costs
     * @return
     */
    public static DijksNode getLowestCostNode(List<DijksNode> costs, List<DijksNode> processedNodes) {
        DijksNode lowestNode = null;
        Integer disctance = Integer.MAX_VALUE;
        for (DijksNode dijksNode : costs) {
            //当前节点到起点的开销小于当前开销并且该节点并未被处理过  则修改新的少的开销
            if (dijksNode.getDistance() < disctance && (!processedNodes.contains(dijksNode))) {
                lowestNode = dijksNode;
                disctance = dijksNode.getDistance();
            }
        }
        return lowestNode;
    }
}
