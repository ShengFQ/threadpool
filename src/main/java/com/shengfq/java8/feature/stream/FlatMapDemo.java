package com.shengfq.java8.feature.stream;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * ClassName: FlatMapDemo Description: flatmap
 *
 * @author shengfq
 * @date: 2023/8/20 12:49 下午
 */
@Data
public class FlatMapDemo {

  private static List<Model> models = new ArrayList<>(0);



  public static void main(final String[] args) {
    initModels();
  }

  private static void initModels() {
    for (int i = 0; i < 10; i++) {
      final Model model = new Model();
      model.setId(i);
      model.setCodes("code" + i + ",code" + i + 1);
      models.add(model);
    }
  }

  /**
   * 将model里面的codes字段,字符串数组提取出来到List集合.
   */
  private static List<String> convertCodes(final List<Model> models) {
    return null;
  }

  @Data
  static class Model {
    int id;
    String codes;
  }
}
