package com.example.demo.disruptor.entity;

//声明一个event 生产者与消费者传递数据类型
public class LongEvent {

	private Long value;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
