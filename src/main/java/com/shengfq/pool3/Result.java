package com.shengfq.pool3;

public class Result {
    private int count;
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Result{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
