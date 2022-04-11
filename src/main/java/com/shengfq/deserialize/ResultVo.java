package com.shengfq.deserialize;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shengfq
 * @version 1.0
 * @date 2022/4/11 08:47
 */
@Data
public class ResultVo<T> implements Serializable {
    private T  data;
    private String msg;
    private int code;
}
