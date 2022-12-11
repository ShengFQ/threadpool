package com.shengfq.algorithm.Iterator;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 树的遍历方式
 * @author sheng
 * */
public class TreeIterator {
    /**
     * 广度优先遍历森林
     *广度优先也就是树的遍历是横向的,逐层遍历,先把高度为1的节点全部访问完,再访问高度为2的节点,以此类推..
     * 广度优先的遍历需要利用队列先进先出的特性,以我建立的树为例,访问顺序是:A->B->C D->E->F->G->H->I->J
     * @param treeList
     */
    public void broadFirst(List<Tree> treeList) {
        treeList.forEach(tree -> broadFist(tree));
    }

    /**
     * 广度优先遍历树
     *
     * @param tree
     */
    private void broadFist(Tree tree) {
        Queue<Tree> queue = new LinkedBlockingQueue<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree firstNode = queue.poll();
            System.out.print(firstNode.getName() + "->");
            if (firstNode.getChildren() != null && firstNode.getChildren().size() > 0) {
                queue.addAll(firstNode.getChildren());
            }
        }
    }

    /**
     * 深度优先遍历森林
     *
     * @param treeList
     */
    public void deepFirst(List<Tree> treeList) {
        treeList.forEach(tree -> deepFirst(tree));
    }

    /**
     * 深度优先遍历树
     *深度优先对树的遍历是纵向的,是一条线走到底,从根节点开始一直找到叶子节点,然后再换另一条线,直到所有孩子都被访问过为止.
     * 深度优先的遍历需要利用栈的先进后出特性来实现,以我在上面建立的树为例,访问顺序为:A->C->B D->G->F->E->I->J->H
     * @param tree
     */
    private void deepFirst(Tree tree) {
        Stack<Tree> stack = new Stack<>();
        stack.add(tree);
        while (!stack.isEmpty()) {
            Tree firstNode = stack.pop();
            System.out.print(firstNode.getName() + "->");
            if (!firstNode.getChildren().isEmpty()) {
                for (Tree child : firstNode.getChildren()) {
                    stack.push(child);
                }
            }
        }
    }
}
