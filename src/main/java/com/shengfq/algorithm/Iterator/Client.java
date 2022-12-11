package com.shengfq.algorithm.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {

    static List<Tree> rootList = new ArrayList<>();
    static  List<Tree> bodyList = new ArrayList<>();

    static {
        init();
    }
    /**
     * 初始化树结构
     * */
    private static void init(){
        Tree tree1 = new Tree(1L,"A",0L);
        Tree tree2 = new Tree(2L,"B",1L);
        Tree tree3 = new Tree(3L,"C",1L);
        Tree tree4 = new Tree(4L,"D",0L);
        Tree tree5 = new Tree(5L,"E",4L);
        Tree tree6 = new Tree(6L,"F",4L);
        Tree tree7 = new Tree(7L,"G",4L);
        Tree tree8 = new Tree(8L,"H",5L);
        Tree tree9 = new Tree(9L,"I",5L);
        Tree tree10 = new Tree(10L,"J",9L);
        rootList.add(tree1);
        rootList.add(tree4);
        bodyList.add(tree2);
        bodyList.add(tree3);
        bodyList.add(tree5);
        bodyList.add(tree6);
        bodyList.add(tree7);
        bodyList.add(tree8);
        bodyList.add(tree9);
        bodyList.add(tree10);
    }

    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder(rootList,bodyList);
        List<Tree> treeList = treeBuilder.build();
        System.out.println(treeList);
        System.out.println("广度遍历算法");
        //广度遍历算法
        TreeIterator iterator1 = new TreeIterator();
        iterator1.broadFirst(treeList);
        //深度遍历算法
        System.out.println();
        System.out.println("深度遍历算法");
        TreeIterator iterator2 = new TreeIterator();
        //iterator.broadFirst(treeList);
        iterator2.deepFirst(treeList);
    }
}
