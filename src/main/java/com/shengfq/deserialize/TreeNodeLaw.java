package com.shengfq.deserialize;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 树形结构
 */
@Setter
@Getter
public class TreeNodeLaw implements Serializable {

    private Long id;

    private String content;

    private Long parentId;

    private List<TreeNodeLaw> children;

    private Integer position;

    private Integer level;

    private Long firstChildrenId;

    private String jsonUrl;

    private int showChild;
}
