package com.shengfq.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: Student
 * Description: shi
 *
 * @author shengfq
 * @date: 2024/3/3 10:05 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private String name;
    private int age;
}
