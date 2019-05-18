package com.algorithm.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 狄科斯拉算法的节点
 * User: lijinpeng
 * Created by Shanghai on 2019/5/18.
 */
@Setter
@Getter
public class DijksNode  implements Serializable{
    /**
     * 节点标志  用于标志A B C 等节点
     */
    private String nodeId;
    /**
     * 父节点
     */
    private DijksNode parentNode;
    /**
     * 邻居节点 以及该节点到邻居节点距离
     */
    Map<DijksNode, Integer> neighbors = new HashMap<DijksNode, Integer>();

    /**
     * 从出起点到该节点的距离
     */
    private Integer distance = Integer.MAX_VALUE;

    public DijksNode(String nodeId) {
        this.nodeId = nodeId;
    }

    public void addNeighbor(DijksNode node, Integer cost) {
        neighbors.put(node, cost);
    }

    public String printWay() {
        if (parentNode != null) {
            return parentNode.printWay() + "-->" + nodeId;
        }
        return nodeId;
    }

    public String toString() {
        return new StringBuilder().append("起点到节点").append(nodeId).append("的最短距离为:").append(distance)
                           .append("\r\n")
                           .append("最短路线为:").append(parentNode == null ? "" : parentNode.printWay())
                           .append("-->").append(nodeId).toString();
    }
}
