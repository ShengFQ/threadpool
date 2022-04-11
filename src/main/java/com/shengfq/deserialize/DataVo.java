package com.shengfq.deserialize;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shengfq
 * @version 1.0
 * @date 2022/4/11 08:52
 */
@Data
public class DataVo implements Serializable {
    private String name;
    private int total;
}
