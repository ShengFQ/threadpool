package com.shengfq.lambda.functional;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private Integer weight;

    public Apple(String color,Integer weight){
        this.color=color;
        this.weight=weight;
    }
}
