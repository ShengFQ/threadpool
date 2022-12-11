package com.shengfq.algorithm.Iterator;

import java.util.*;
/**
 * 树的构建
 * @author sheng
 * */
public class TreeBuilder {
    /**
     * 根节点列表
     */
    private List<Tree> rootList;
    /**
     * 非根节点列表 当然也可以包含根 不影响
     */
    private List<Tree> bodyList;

    public TreeBuilder(List<Tree> rootList, List<Tree> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<Tree> build() {
        Map<Long, Long> filterOperated = new HashMap<>(rootList.size() + bodyList.size());
        //对每个根节点都封装它的孩子节点
        rootList.forEach(root -> setChildren(root, filterOperated));
        return rootList;
    }

    private void setChildren(Tree root, Map<Long, Long> filterOperated) {
        List<Tree> children = new ArrayList<>();
        bodyList.stream()
            //过滤出未操作过的节点
            .filter(body -> !filterOperated.containsKey(body.getId()))
            //过滤出孩子节点
            .filter(body -> Objects.equals(root.getId(), body.getParentId()))
            .forEach(body -> {
                filterOperated.put(body.getId(), root.getId());
                children.add(body);
                //递归 对每个孩子节点执行同样操作
                setChildren(body, filterOperated);
            });
        root.setChildren(children);
    }
}
