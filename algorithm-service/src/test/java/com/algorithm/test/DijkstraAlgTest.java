package com.algorithm.test;

import com.algorithm.model.DijksNode;
import com.algorithm.service.DijkstraAlg;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lijinpeng
 * Created by Shanghai on 2019/5/18.
 */
public class DijkstraAlgTest {
    @Test
    public void dijkstraAlgTest() {
        DijksNode dijksNode = new DijksNode("O");//起点 0
        DijksNode dijksNodeE = new DijksNode("E");//终点E
        dijksNode.setDistance(0);
        DijksNode dijksNodeA = new DijksNode("A");
        DijksNode dijksNodeB = new DijksNode("B");
        DijksNode dijksNodeC = new DijksNode("C");
        dijksNodeA.setParentNode(dijksNode);
        dijksNodeB.setParentNode(dijksNode);
        dijksNode.addNeighbor(dijksNodeA, 6);//O->A 6
        dijksNode.addNeighbor(dijksNodeB, 2);//O->B 2
        dijksNodeB.addNeighbor(dijksNodeA, 3);//B->A 3
        dijksNodeA.addNeighbor(dijksNodeE, 1);//A->E 1
        dijksNodeB.addNeighbor(dijksNodeE, 5);//B->E 5
        dijksNodeB.addNeighbor(dijksNodeC, 1);//B->C 1
//        dijksNodeC.addNeighbor(dijksNodeE, 1);//C->E 1
        List<DijksNode> listData = new ArrayList<DijksNode>();
        listData.add(dijksNode);
        listData.add(dijksNodeA);
        listData.add(dijksNodeB);
//        listData.add(dijksNodeC);
        listData.add(dijksNodeE);
        DijkstraAlg.dijkstraAlg(listData);
        for (DijksNode newNode : listData) {
            System.out.println(newNode);
        }
    }
}
