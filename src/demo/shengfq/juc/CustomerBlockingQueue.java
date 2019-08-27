package demo.shengfq.juc;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * Created by sheng on 18/6/8.
 * 用于保存等待执行的任务的阻塞队列
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
 * LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
 * SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
 *PriorityBlockingQueue：一个具有优先级得无限阻塞队列。

 */
public class CustomerBlockingQueue extends ArrayBlockingQueue{
    public CustomerBlockingQueue(int capacity) {
        super(capacity);
    }
}
