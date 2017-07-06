package com.demo;

import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;

import com.face.Hello;
import com.face.HelloImpl;
import com.face.HelloImpl2;

/**
 * @author huangdaye
 *
 */
public class Demo {

	private List<Integer> list;
	private Hello h1;
	private Hello h2;
	
	@Before
	public void boefore(){
		//实例化list对象并赋值
		list=new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(8);
		list.add(12);
		list.add(19);
		list.add(111);
		list.add(null);
		list.add(333);
		
		//实例化接口对象
	    h1=new HelloImpl();
	    h2=new HelloImpl2();
	}
	
	/**
	 * 1.测试Lambda表达式
	 */
	@Test
	public void Lambda(){
		list.forEach(System.out::println);
		list.forEach(e -> System.out.println("方式二:"+e));
	}
	
	/**
	 * 2.Stream函数式操作流元素集合
	 */
	@Test
	public void stream(){
		System.out.println("求和:"+list
				.stream()//转成stream
		        .filter(team -> team!=null)//过滤
		        .distinct()//去重
		        .mapToInt(map->map*2)//map操作
		        .skip(2)//跳过前2个元素
		        .limit(4)//限制前4个元素
		        .peek(System.out::println)//流式处理对象函数
		        .sum());
	}
	
	/**
	 * 3.接口新增，可以定义静态方法和默认方法
	 */
	@Test
	public void TestInterface(){
		Hello.hello();
		h1.world();
		h2.world();
	}
	
	/**
	 * 4.重复注解
	 * 5.类型注解
	 * 6.最新的Date/Time API
	 */
	@Test
	public void dateAndTime(){
		//1.Clock
		Clock clock=Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());
		
		//2. ISO-8601格式且无时区信息的日期部分
		LocalDate date=LocalDate.now();
		LocalDate localDate=LocalDate.now(clock);
		System.out.println(date);
		System.out.println(localDate);
		
		//3.ISO-8601格式且无时区信息的时间部分
		LocalTime time=LocalTime.now();
		LocalTime localTime=LocalTime.now(clock);
		System.out.println(time);
		System.out.println(localTime);
		
		//4.ISO-8601格式无时区信息的日期与时间
		LocalDateTime dateTime=LocalDateTime.now();
		LocalDateTime localDateTime=LocalDateTime.now(clock);
		System.out.println(dateTime);
		System.out.println(localDateTime);
		
		//5.特定时区的日期/时间
		ZonedDateTime zoned1=ZonedDateTime.now();
		ZonedDateTime zoned2=ZonedDateTime.now(clock);
		ZonedDateTime zoned3=ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(zoned1);
		System.out.println(zoned2);
		System.out.println(zoned3);
		
		//6.在秒与纳秒级别上的一段时间
		LocalDateTime from=LocalDateTime.of(2014, Month.JUNE, 15, 12, 34, 23, 3);
		LocalDateTime to=LocalDateTime.of(2015, Month.AUGUST, 12, 14, 23, 44, 6);
		Duration duration=Duration.between(from, to);
		System.out.println("Duration in Days:"+duration.toDays());
		System.out.println("Duration in Hours:"+duration.toHours());
	}
	
	/**
	 * 7.Base64加密解密API
	 */
	@Test
	public void baseTest(){
		String text="我要测试解密；rewerwe@@@!!!";
		//进行加密
		String encoded=Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println("加密后:"+encoded);
		//进行解密
		String decoded=new String(Base64.getDecoder().decode(encoded),StandardCharsets.UTF_8);
		System.out.println("解密后:"+decoded);
		
	}
	
	/**
	 * 数组(Array)并行操作
	 */
	@Test
	public void arraryTest(){
		long[] arraryLong=new long[2000];
		//给数组随机赋值
		Arrays.parallelSetAll(arraryLong, index ->ThreadLocalRandom.current().nextInt(10000));
		
		//打印前10个元素
		Arrays.stream(arraryLong).limit(10).forEach(a ->System.out.print(a+" "));
		
		//数组排序
		Arrays.parallelSort(arraryLong);
		//打印排序后的前10个元素
	    Arrays.stream(arraryLong).limit(10).forEach(a ->System.out.print(a+" "));
	}
}
