package com.shengfq.io.files.pdf;

import lombok.Getter;

/**
 * ClassName: DocTypeEnum
 * Description: 法律文书的文种
 *
 * @author shengfq
 * @date: 2023/1/3 11:15 上午
 */
@Getter
public enum DocTypeEnum {

    LAJDS(1,"立案决定书"),
    XZCXCCTZS(2,"协助查询财产通知书"),
    XZDJCCTZS(3,"协助冻结财产通知书");

    private Integer code;

    private String name;

    DocTypeEnum(Integer code,String name){
        this.code=code;
        this.name=name;
    }

}
