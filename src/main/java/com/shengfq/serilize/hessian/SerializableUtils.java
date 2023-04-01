package com.shengfq.serilize.hessian;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ClassName: SerializableUtils
 * Description: jdk自带的serialize序列化
 *
 * @author shengfq
 * @date: 2023/3/20 3:26 下午
 */
public class SerializableUtils {
    public static <T> byte[] serialize(T javaBean) throws Exception {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream out=null;
        try {
            baos = new ByteArrayOutputStream();
            out= new ObjectOutputStream(baos);
            out.writeObject(javaBean);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (null != out) {
                out.close();
            }
        }
        return baos.toByteArray();
    }

    public static <T> T deserialize(byte[] serializeData) throws Exception {
        ByteArrayInputStream baos = null;
        ObjectInputStream in=null;
        try {
            baos = new ByteArrayInputStream(serializeData);
            in= new ObjectInputStream(baos);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (null != in) {
                in.close();
            }
        }
        return  (T)in.readObject();
    }
}
