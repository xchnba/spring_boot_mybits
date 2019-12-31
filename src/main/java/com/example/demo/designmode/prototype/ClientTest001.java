package com.example.demo.designmode.prototype;

// 因为String类型被final 不能被更改。
public class ClientTest001 {

	public static void main(String[] args) throws CloneNotSupportedException {
		// 被克隆对象
		Book book1 = new Book();
		book1.setTitle("图书1");
		book1.addImg("图片1");
		book1.setAge(10);
		book1.showBook();

		// 开始克隆对象 以原型方式进行复制拷贝
		Book book2 = (Book) book1.clone();
		book2.setTitle("图书2");
		book2.addImg("图片2");
		book2.setAge(20);
		book2.showBook();

		// 打印原型日志
		book1.showBook();
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book1 == book2);

	}

}
