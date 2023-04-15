package com.shengfq.collection;

import java.util.*;

/**
 * ClassName: GiftOne
 * Description: 随机抽奖算法
 * 1.抽奖的业务逻辑,从一个集合中随机抽取一个样本,拿到该值就从集合中删除该值,一人只参与一次抽奖
 * 2.有多个奖项,每个奖项支持多个人参与,例如1等奖1个,2等奖2个,3等奖3个.
 * 3.游戏支持指令结束,最终输出所有获奖人名单
 * @author shengfq
 * @date: 2023/4/15 10:36 上午
 */
public class GiftOne {
    //数据结构
    //奖项列表 awards 奖项 人数 奖品

    //参与人列表 members id 人名

    //待抽奖人员列表players，是members 的子集

    //抽奖结果列表result，按奖项顺序索引
    private  String[] members=new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
            "P","Q","R","X","T","U","V","W","X","Y","Z"};

    private  HashMap<String, List<String>> dashboard=new HashMap<String, List<String>>(15);
    /**
     * 核心数据结构是支持 pull,take
     * */

    private  List<String> participantIds=new ArrayList<>(members.length);

    public GiftOne(){
        initQueue();
    }
    private void initQueue(){
        for (int i = 0; i < members.length; i++) {
            participantIds.add(members[i]);
        }
    }


    /**
     * 随机算法
     * */
    private  String random(){
        Random random=new Random();
       int index= random.nextInt(members.length);
       return members[index];
    }

    public static void main(String[] args) {
        GiftOne test=new GiftOne();
        Scanner input=new Scanner(System.in);
        System.out.println("开始抽奖,按n开始:");
        while (input.hasNext()){
            String command=input.next();
            switch (command){
                case "n":

                    continue;
                case "q":
                    break;
            }
        }
        System.out.printf("抽奖结束");
    }

    public static void printResult(List<String> result){
        result.stream().forEach(System.out::println);
    }


}
