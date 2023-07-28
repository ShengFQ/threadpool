package com.shengfq.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.util.CollectionUtils;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gw_guoy
 * @desciption 分页工具类
 * @date 2021/12/16
 */
@Slf4j
public class PageUtil {
    /**
     * 批量大小
     */
    static final Integer BATCH_COUNT = 10;
    /**
     * 私有化构造方法
     */
    private PageUtil() {
    }

    /**
     * 从列表集合中根据分页参数获取对应页数列表记录
     *
     * @param pageList
     * @param pageSize
     * @param pageNo
     * @return
     */
    public static <T> List<T> getPageResult(List<T> pageList, int pageSize, int pageNo) {
        if (CollectionUtils.isEmpty(pageList)) {
            return pageList;
        }
        if (pageList.size() > (pageNo - 1) * pageSize) {
            // 若存在pageNo的页数(包括首页)
            return pageList.subList((pageNo - 1) * pageSize, Math.min(pageList.size(), pageNo * pageSize));
        }
        int maxPageNo = pageList.size() / pageSize + (pageList.size() % pageSize != 0 ? 1 : 0);
        if (pageNo > maxPageNo) {
            return Collections.emptyList();
        }
        return pageList.subList((maxPageNo - 1) * pageSize, pageList.size());
    }


    /**
     * 批量查询时拆分查询
     *
     * @param list
     * @param function
     */
    public static <T, K> List<K> splitQuery(List<T> list, Function<List<T>, List<K>> function) {
        return splitQuery(list, BATCH_COUNT, function);
    }

    /**
     * 批量拆分消费
     *
     * @param list
     * @param consumer
     */
    public static <T> void splitConsumer(List<T> list,
                                        Consumer<List<T>> consumer) {
        splitConsumer(list, BATCH_COUNT, consumer);
    }

    /**
     * 批量拆分消费
     *
     * @param list
     * @param consumer
     */
    public static <T> void splitConsumer(List<T> list,
                                         Integer batchSize,
                                         Consumer<List<T>> consumer) {
        Integer realBatchSize = (Objects.isNull(batchSize) || batchSize < 0 || batchSize > 5000) ?
                BATCH_COUNT : batchSize;
        if (CollUtil.isNotEmpty(list)) {
            if (list.size() <= realBatchSize) {
                consumer.accept(list);
            } else {
                // 数据条数太多则分批执行
                int totalSize = getTotalSize(list, realBatchSize);
                for (int i = 0; i < totalSize; i++) {
                    List<T> subParams = PageUtil.getPageResult(list, realBatchSize, i + 1);
                    consumer.accept(subParams);
                }
            }
        }
    }


    /**
     * 批量查询时拆分查询
     *
     * @param list
     * @param batchSize
     * @param function
     */
    public static <T, K> List<K> splitQuery(List<T> list,
                                            Integer batchSize,
                                            Function<List<T>, List<K>> function) {
        Integer realBatchSize = (Objects.isNull(batchSize) || batchSize < 0 || batchSize > 5) ?
                BATCH_COUNT : batchSize;
        List<K> resultList = new ArrayList<>(16);
        if (!CollectionUtils.isEmpty(list)) {
            if (list.size() <= realBatchSize) {
                List<K> allList = function.apply(list);
                resultList.addAll(allList);
            } else {
                // 数据条数太多则分批执行
                int totalSize = getTotalSize(list, realBatchSize);
                for (int i = 0; i < totalSize; i++) {
                    List<T> subParams = PageUtil.getPageResult(list, realBatchSize, i + 1);
                    List<K> subList = function.apply(subParams);
                    resultList.addAll(subList);
                }
            }
        }
        return resultList;
    }


    /**
     * 获取总页数
     *
     * @param list
     * @param size
     * @param <T>
     * @return
     */
    private static <T> int getTotalSize(List<T> list, Integer size) {
        return list.size() % size == 0 ? (list.size() / size) : (list.size() / size + 1);
    }
}
