package com.shengfq.java8.feature.lambda;

public class Apple  {
    private String type;
    private int weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Apple(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}
