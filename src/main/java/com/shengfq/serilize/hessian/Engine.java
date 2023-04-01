package com.shengfq.serilize.hessian;

import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * ClassName: Engine
 * Description: TODO
 *
 * @author shengfq
 * @date: 2023/3/20 5:41 下午
 */
@ToString
public class Engine implements Externalizable {
    private float power;
    private String model;

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(model);
        out.writeFloat(power);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("[模拟日志记录]readExternal.");
        model = in.readUTF();
        power = in.readFloat();
    }
}
