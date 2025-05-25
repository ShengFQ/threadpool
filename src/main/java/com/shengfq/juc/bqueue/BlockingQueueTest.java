package com.shengfq.juc.bqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jackyuj
 */
public class BlockingQueueTest {
    private static final int size=20;
    private ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(size);
// 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则抛出 IllegalStateException。
    private boolean add(Integer num){
       return queue.add(num);
    }
// 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
    private boolean offer(Integer num){
        return queue.offer(num);
    }

    //TODO 将指定的元素插入此队列的尾部，如果该队列已满，则等待可用的空间。
    private void put(Integer num) throws InterruptedException {
         queue.put(num);
    }
    // 获取但不移除此队列的头；如果此队列为空，则返回 null。
    private Integer peek(){
       return queue.peek();
    }
    // 获取并移除此队列的头，如果此队列为空，则返回 null。
    private Integer poll(){
        return queue.poll();
    }
    //TODO 获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
    private Integer take() throws InterruptedException{
        return queue.take();
    }
    // 从此队列中移除指定元素的单个实例（如果存在）
    private boolean remove(Integer num){
        return queue.remove(num);
    }
    // 返回此队列中元素的数量。
    private int getSize(){
      return queue.size();
    }
    public static void main(String[] args) {

    }


}
