package com.example.demo.designmode.prototype;

import java.util.ArrayList;
import java.util.List;

public class Book extends Object implements Cloneable {

	// 名称
	private String title;
	// 图片
	private ArrayList<String> listImg = new ArrayList<>();
	private int age;

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getListImg() {
		return listImg;
	}

	public void setListImg(ArrayList<String> listImg) {
		this.listImg = listImg;
	}

	public void addImg(String imgName) {
		listImg.add(imgName);
	}

	public void showBook() {
		System.out.println("...............start..............");
		System.out.println("title:" + title);
		for (String imgs : listImg) {
			System.out.println("img name :" + imgs + " ");
		}
		System.out.println("age:" + this.age);
		System.out.println("...............end..............");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	protected Object clone() throws CloneNotSupportedException {
		// 浅克隆 深克隆 默认是浅克隆
		Book book = (Book) super.clone();
		// 属性深克隆
		book.listImg = (ArrayList<String>) this.listImg.clone();
		return book;
	}

}
