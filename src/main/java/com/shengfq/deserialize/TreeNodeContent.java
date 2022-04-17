package com.shengfq.deserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * copyRight 二三三网络技术
 * className     com.shengfq.deserialize.TreeNodeContent
 * description   TODO
 *
 * @author shengfq
 * @version 1.0
 * @date 2022/4/14 10:16
 */
@Data
@NoArgsConstructor
public class TreeNodeContent implements Serializable {

    private Integer showChild;

    private String lawWebContent;

    private Integer j;

    private Integer id;

    private Integer position;

    private Integer type;

    private String content;

    private Integer parentId;
}
