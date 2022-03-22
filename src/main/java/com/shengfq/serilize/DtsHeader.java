package com.shengfq.serilize;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Classname TaskDataDto
 * @Description TODO
 * @Date 2021/1/21 8:45
 * @Created by kangyu
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DtsHeader {

    /**
     * 系统
     * example:BMS
     */
    private String system;

    /**
     * 任务id
     * example:studyStageSync
     */
    private String taskId;

    /**
     * example:bms20210118xxx
     */
    private String sid;

    /**
     * 操作人
     * example:kangyu
     */
    private String operator;

    /**
     * MQ推送时间搓
     */
    private Long timestamp;

    /**
     * 是否立即执行：默认否
     */
    private Boolean isRapid;

}
