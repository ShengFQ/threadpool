package com.shengfq.concurrent.lock;
/**
 * 悲观锁案例
 * @author sheng
 *  * @date 2020-08-05
 *
 *  乐观锁适合读操作多的场景，不加锁的特点能够使其读操作的性能大幅提升
 *  何乐观锁能够做到不锁定同步资源也可以正确的实现线程同步呢？CAS
 *
 * */
public class PassiveLock {


    /**
     * CAS全称 Compare And Swap（比较与交换），是一种无锁算法
     * 需要读写的内存值 V。
     * 进行比较的值 A。
     * 要写入的新值 B
     * */
}
