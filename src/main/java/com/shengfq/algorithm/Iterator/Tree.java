package com.shengfq.algorithm.Iterator;

import java.util.List;
/**
 * 参考:https://blog.csdn.net/lovexiaotaozi/article/details/102718254?spm=1001.2014.3001.5501
 * 树的深度遍历和广度遍历
 * */
public class Tree {
    /**
     * 当前节点的id
     */
    private Long id;
    /**
     * 当前节点的名字
     */
    private String name;
    /**
     * 当前节点对应父亲节点的id
     */
    private Long parentId;
    /**
     * 当前节点的孩子节点列表
     */
    private List<Tree> children;

    public Tree(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", parentId=" + parentId +
            '}';
    }
}
