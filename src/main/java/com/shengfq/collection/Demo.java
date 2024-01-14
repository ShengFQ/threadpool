package com.shengfq.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class Demo {

  /**
   * 例：将 modelList 按type分组位后得到 （取ID为例） [type = 1] = [1, 2, 3], [type = 2] = [4], [type = 3] = [5, 6,
   * 7] 求笛卡尔积的结果应为[1, 4, 5] ,[1, 4, 6], [1, 4, 7],[2, 4, 5],[2, 4, 6],[2, 4, 7],[3, 4, 5],[3, 4,
   * 6],[3, 4, 7]
   */

  public static void main(final String[] args) {
    final List<Model> modelList = Lists.newArrayList();
    modelList.add(new Model(1, "a", "zhuoli", 1));
    modelList.add(new Model(2, "b", "zhuoli", 1));
    modelList.add(new Model(3, "c", "Alice", 1));

    // modelList.add(new Model(4, "d", "zhuoli", 2));

    modelList.add(new Model(5, "e", "zhuoli", 3));
    modelList.add(new Model(6, "f", "Michael", 3));
    modelList.add(new Model(7, "g", "Michael", 3));

    // 按指定字段（type）分组
    final Map<Integer, List<Model>> modelMap =
        modelList.stream().collect(Collectors.groupingBy(Model::getType));
    final Collection<List<Model>> mapValues = modelMap.values();
    final List<List<Model>> dimensionValue = new ArrayList<>(mapValues); // 原List

    final List<List<Model>> result = new ArrayList<>(); // 返回集合
    new DescartesCollection<Model>().descartes(dimensionValue, result, 0, new ArrayList<Model>());


    for (final List<Model> models : result) {
      final List<Integer> resList = new ArrayList<>();
      for (final Model model : models) {
        resList.add(model.getId());
      }
      System.out.println("-----" + resList.toString());
    }


  }

  @Data
  @AllArgsConstructor
  @ToString
  static class Model {
    private Integer id;

    private String name;

    private String author;

    private Integer type;
  }
}
