package com.shengfq.reflect;

import lombok.Getter;
import lombok.Setter;

public class Fruits {
    public String name;
    public int hot;
    public int sugar;

    @Getter
    public double weight;

    @Getter
    @Setter
    private double price;

    /**
     * 水果的总价
     * */
    public double total(){
        if(weight==0 || price==0){
            return 0;
        }
      return  this.weight*this.price;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "name='" + name + '\'' +
                ", hot=" + hot +
                ", sugar=" + sugar +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
