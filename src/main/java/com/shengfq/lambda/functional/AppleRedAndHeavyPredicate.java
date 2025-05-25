package com.shengfq.lambda.functional;

public class AppleRedAndHeavyPredicate implements Predicate<Apple> {

    /**
     * 挑选苹果的条件行为
     *
     * @param apple
     */
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
