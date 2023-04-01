package com.shengfq.serilize.hessian;

import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author Securitit.
 * @note Car Pojo.
 */
@ToString
public class Car implements Externalizable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 3943382426658456693L;
	/**
	 * 静态字段不会序列化
	 * */
	private  Engine engine;
	/**
	 * 名称.
	 */
	private String name;

	/**
	 * 价格.
	 */
	private Integer price;

	/**
	 * 颜色.
	 */
	private String color;

	/**
	 * 长度.
	 * TODO 不想序列化的加关键字transient
	 */
	private transient int length;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(price);
		out.writeUTF(color);
		out.writeInt(length);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("[模拟日志记录]readExternal.");

		name = in.readUTF();
		price = in.readInt();
		color = in.readUTF();
		length = in.readInt();
	}

}
