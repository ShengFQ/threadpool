package com.shengfq.designpatten.chain.demo1;

import lombok.Data;

/**
 * ClassName: Request
 * Description: 请假请求
 *
 * @author shengfq
 * @date: 2024/2/3 11:33 上午
 */
@Data
public class Request {
    private String name;
    private int holiday;
    public Request(String name,int holiday){
        this.name=name;
        this.holiday=holiday;
    }
    @Override
    public String toString(){
        return this.name+"请假:"+this.holiday;
    }
}
