package com.shengfq.algorithm.search;

/**
 * ClassName: BSearchTest
 * Description: 二分查找法
 *
 * @author shengfq
 * @date: 2024/3/29 10:40 下午
 */
public class BSearchTest {

    public static void main(String[] args) {
        int[] r=new int[]{1,3,5,7,9,10,11,12,13,14,15,20,30,40,50,60,70,80,90};
        int key=5;
        int low=0, high=r.length-1;
        int target=  bSearch(r,low,high,key);
        System.out.println(" bSearch key "+key+" is index:"+target);
        System.out.println("===========");

        target=bSearch2(r,low,high,key);
        System.out.println("bSearch2 key "+key+" is index:"+target);
    }

    /**
     * 适用于递增元素的数组,也就是说在查找前要先进行排序
     * 元素存在在source里,用二分查找在数组source中查找值为key的元素位置,并返回
     *  low 最左游标
     *  high 最右游标
     * @param key 目标元素
     * */
    public static int bSearch(int[] source,int low,int high,int key){
        //目标索引
        int target=-1;
        //中间索引
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(key==source[mid]){
                target=mid;
                System.out.println("times++");
                return target;
            }else if(key>source[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
            System.out.println("times++");
        }
        return target;
    }

    /**
     * 适用于非递增元素的数组
     * */
    public static int bSearch2(int[] source,int low,int high,int key){
        int target=-1;
        if(low<=high){
            int mid=(low+high)/2;
            if(key==source[mid]){
                target=mid;
                System.out.println("times++");
                return target;
            }else if(key<source[mid]){
                //再次进行二分
                target=  bSearch2(source,low,mid-1,key);
                System.out.println("times++");
                return target;
            }else{
                target=bSearch2(source,mid+1,high,key);
                System.out.println("times++");
                return target;
            }

        }else{
            return target;
        }
    }
}
