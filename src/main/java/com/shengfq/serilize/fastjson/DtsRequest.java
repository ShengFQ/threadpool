package com.shengfq.serilize.fastjson;

import lombok.*;

/**
 * @ClassName DtsRequest
 * @Description Dts请求类
 * @Author Luozelin
 * @Date 2021/2/6 0006 下午 2:15
 * @Version
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DtsRequest {

    /**
     * header 参数
     */
    private DtsHeader header;

    /**
     * body 参数
     */
    private DtsBody body;


}
