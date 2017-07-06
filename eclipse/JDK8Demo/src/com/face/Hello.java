package com.face;

public interface Hello {

	//1.接口中可以定义静态方法了
	public static void hello(){
		System.out.println("hello,Jdk 8");
	}
	
	//使用default后接口中可以定义普通方法体
	public default void world(){
		System.out.println("大家好，我是接口里面的默认方法");
	}
}
