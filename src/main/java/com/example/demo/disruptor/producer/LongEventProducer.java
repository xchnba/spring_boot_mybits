package com.example.demo.disruptor.producer;

import java.nio.ByteBuffer;


import com.example.demo.disruptor.entity.LongEvent;
import com.lmax.disruptor.RingBuffer;

// 生产者
public class LongEventProducer {
	private RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer byteBuffer) {
		// 获取事件队列 下标位置
		long sequence = ringBuffer.next();
		try {
			// 取出空队列（Event）
			LongEvent longEvent = ringBuffer.get(sequence);
			// 给空队列赋值
			longEvent.setValue(byteBuffer.getLong(0));
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("生产者发送数据...");
			// 发送数据
			ringBuffer.publish(sequence);
		}
	}

}
