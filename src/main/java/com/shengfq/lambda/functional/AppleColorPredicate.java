package com.shengfq.lambda.functional;

public class AppleColorPredicate implements Predicate<Apple> {
    /**
     * 挑选苹果的条件行为
     *
     * @param apple
     */
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
