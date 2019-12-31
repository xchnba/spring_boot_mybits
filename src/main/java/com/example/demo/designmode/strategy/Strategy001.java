package com.example.demo.designmode.strategy;

public class Strategy001 {

	public static void main(String[] args) {

	}

	// 蚂蚁课堂会员分为 3种级别 铂金会员 黄金会员 普通会员。
	public void getPrice(String leve) {
		Long price = null;
		if (leve.equals("铂金会员")) {
			// 只需要100元
			price = (long) (100 * 100);
		} else if (leve.equals("黄金会员")) {
			price = (long) (100 * 150);
		} else if (leve.equals("普通会员")) {
			price = (long) (100 * 200);
		}
	}

}
