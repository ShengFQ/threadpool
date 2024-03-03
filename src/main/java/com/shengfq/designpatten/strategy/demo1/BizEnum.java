package com.shengfq.designpatten.strategy.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class BizEnum {
  /**
   * BizTypeEnum 业务商品表类型 枚举
   *
   * @author chenkaimin
   * @Date 2023/7/3 14:59
   * @Description
   */
  @Getter
  @AllArgsConstructor
  public enum BizTypeEnum {
    Keep_Curriculum("keep_curriculum", "keep 课程"), Keep_Activity("keep_activity", "keep 活动"),;

    String code;
    String desc;
  }
}
