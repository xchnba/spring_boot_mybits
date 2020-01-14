package com.example.demo.sourcecode.arraylist;

/**
 * 自定义list接口 <br>
 */
public interface ExtList<E> {
	public void add(E e);

	public int getSize();

	public E get(int index);
}
