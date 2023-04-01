package com.shengfq.serilize.hessian;

/**
 * @author Securitit.
 * @note HessianUtils测试类.
 */
public class Hessian2UtilsTester {

    public static void main(String[] args) throws Exception {
        byte[] hessian2Data = null;
        Car deserializeCar = null;
        Engine engine=new Engine();
        engine.setModel("E1");
        engine.setPower(100);
        Car car = new Car();
        car.setEngine(engine);
        car.setName("布加迪");
        car.setPrice(12000000);
        car.setColor("红色");
        car.setLength(2980);
        //如果序列化类里面包含了其他引用对象,该对象也要实现序列化接口
        hessian2Data = Hessian2Utils.serialize(car);
        System.out.println("Hessian序列化数据：" + new String(hessian2Data));

        deserializeCar = Hessian2Utils.deserialize(hessian2Data);
        System.out.println("Hessian反序列化数据：" + deserializeCar);

        hessian2Data = SerializableUtils.serialize(car);
        System.out.println("jdk序列化数据：" + new String(hessian2Data));

        deserializeCar = SerializableUtils.deserialize(hessian2Data);
        System.out.println("jdk反序列化数据：" + deserializeCar);
    }

}
