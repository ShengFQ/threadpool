package com.shengfq.deserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author shengfq
 * @version 1.0
 * @date 2022/4/11 08:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataVo implements Serializable {
    private String name;
    private int total;
}
