package demo.shengfq.collection;

import java.util.*;

/**
 * Created by sheng on 18/8/16.
 * 集合框架的性能
 * 工具类的使用
 */
public class TestCollection {
    /***/
    public static void main(String[] args){
        TestCollection test=new TestCollection();
      Collection<Cell> collection=  test.getQueue();
        Iterator<Cell> iterator=collection.iterator();
        long begin=System.currentTimeMillis();
        while(iterator.hasNext()){
            Cell cell=iterator.next();
            System.out.print(cell.getA());
        }
        long end=System.currentTimeMillis()-begin;
        System.out.println("cost :"+end+" ms");
    }

    /**
     * 添加1000个元素,遍历需要15ms
     * */
    public  List<Cell> getList(){
        List<Cell> cells=new LinkedList<Cell>();
        for(int i=0;i<1000;i++) {
            cells.add(new Cell("a"+i));
        }
        return cells;
    }
    /**
     * 添加1000个元素,遍历需要11ms
     * */
    public Set<Cell> getSet(){
        Set<Cell> cells=new TreeSet<Cell>();
        for(int i=0;i<1000;i++) {
            cells.add(new Cell("a"+i));
        }
        return cells;
    }
    /**
     * 添加1000个元素,遍历需要13ms
     * */
    public Queue<Cell> getQueue(){
        Queue<Cell> cells=new PriorityQueue<Cell>();
        for(int i=0;i<1000;i++) {
            cells.add(new Cell("a"+i));
        }
        return cells;
    }

    /**
     * 存储引用对象
     * */
    class Cell implements Comparable{
        private String a;
        public Cell(String a){
            this.a=a;
        }
        public String getA(){
            return a;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Cell){
                Cell com=(Cell)o;
                return ((Cell) o).getA().compareTo(this.a);
            }
            return 0;
        }
    }
}
