package com.shengfq.serilize.hessian;

/**
 * @author Securitit.
 * @note Hessian和Serializable对比测试类.
 */
public class Hessian2VsSerializableTester {

    public static void main(String[] args) throws Exception {
        byte[] hessian2Data = null;
        byte[] serializeData = null;

        Car car = new Car();
        car.setName("布加迪");
        car.setPrice(12000000);
        car.setColor("红色");
        car.setLength(2980);
        //hessian有压缩字节的作用
        hessian2Data = Hessian2Utils.serialize(car);
        System.out.println("Hessian序列化数据：" + hessian2Data);
        System.out.println("Hessian序列化数据大小：" + hessian2Data.length);

        serializeData = SerializableUtils.serialize(car);
        System.out.println("Serializable序列化数据：" + serializeData);
        System.out.println("Serializable序列化数据大小：" + serializeData.length);
    }

}
