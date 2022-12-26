package com.shengfq.io.files.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName: Xzdjcc
 * Description: 协助冻结财产通知书内容
 *
 * @author shengfq
 * @date: 2022/12/20 6:04 下午
 */
@Getter
@Setter
@ToString
public class Xzdjtzs implements AbsContent{
    //通知书业务类型 冻结
    private String tzywlx;
    //银行名称
    private String yhmc;
    //犯罪嫌疑人姓名
    private String  xyrxm;
    //嫌疑人账号
    private String yhzh;
    //冻结数额
    private String  djse;
    //冻结类型 只进不出
    private String djlx;
    //冻结开始日期
    private String djksrq;
    //冻结结束日期
    private String djjsrq;


}
