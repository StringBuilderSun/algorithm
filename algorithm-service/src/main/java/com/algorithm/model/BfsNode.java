package com.algorithm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用于存储节点的顺序
 * User: lijinpeng
 * Created by Shanghai on 2019/5/17.
 */
@Setter
@Getter
@AllArgsConstructor
public class BfsNode implements Serializable {
    private BfsNode parentBfsNode;
    private String nodeValue;

    public String toString() {
        if (parentBfsNode != null) {
            return parentBfsNode.toString() + "-" + nodeValue;
        } else {
            return nodeValue;
        }
    }
}
