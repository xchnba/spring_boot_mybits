package com.example.demo.disruptor.factory;


import com.example.demo.disruptor.entity.LongEvent;
import com.lmax.disruptor.EventFactory;

// EventFactory 实例化LongEvent
public class LongEventFactory implements EventFactory<LongEvent> {

	public LongEvent newInstance() {

		return new LongEvent();
	}

}
