package com.example.demo.designmode.strategy;

//httpservlet 模版方法 策略模式 门面
//策略模式定义抽象公共算法
abstract interface Strategy {

	void algorithmInterface();

}

// 初级会员 针对算法A算法
class StrategyA implements Strategy {

	public void algorithmInterface() {
		System.out.println("初级会员针对A算法");
	}

}

// 初级会员 针对算法B算法
class StrategyB implements Strategy {

	@Override
	public void algorithmInterface() {
		System.out.println("中级会员针对B算法");
	}

}

// 初级会员 针对算法C算法
class StrategyC implements Strategy {

	@Override
	public void algorithmInterface() {
		System.out.println("高级会员针对C算法");
	}

}

class Context {
	private Strategy strategy;

	Context(Strategy strategy) {
		this.strategy = strategy;
	}

	void algorithmInterface() {
		strategy.algorithmInterface();
	}

}

public class StrategyTest {
	Context context;

	public static void main(String[] args) {
		Context context = null;
		Strategy strategyA = new StrategyA();
		context = new Context(strategyA);
		context.algorithmInterface();

		Strategy strategyB = new StrategyB();
		context = new Context(strategyB);
		context.algorithmInterface();

		Strategy strategyC = new StrategyC();
		context = new Context(strategyC);
		context.algorithmInterface();
	}
}
