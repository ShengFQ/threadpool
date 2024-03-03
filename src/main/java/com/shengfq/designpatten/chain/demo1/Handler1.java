package com.shengfq.designpatten.chain.demo1;

import lombok.Builder;
import lombok.Data;

/**
 * ClassName: Handler1
 * Description:
 *
 * @author shengfq
 * @date: 2024/2/3 11:36 上午
 */
@Data
public class Handler1 extends AbsHandler{

    /**
     * 处理方法抽象
     *
     * @param request
     */
    @Override
    public void handle(Request request) {
        if(request.getHoliday()<=3){
            System.out.println("组长处理请求"+request.toString());
        }
    }
}
