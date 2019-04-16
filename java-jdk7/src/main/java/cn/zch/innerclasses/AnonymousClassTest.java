package cn.zch.innerclasses;

import java.util.Arrays;
import java.util.Comparator;

/**
* 匿名类
* 
* 匿名类没有名字，匿名类在使用的同时被声明和初始化，匿名类可以出现在任何允许存在表达式的地方。
* 匿名类的一种常见用法是动态的创建函数对象。
* 例如，利用匿名的Comparator实例，根据字符串长度对字符串数组进行排序。
* @author zch
*/
public class AnonymousClassTest {
	public static void main(String[] args) { 
		String[] strs={"ab","aaaa","CC","abc"}; 
		Arrays.sort(strs,new Comparator<String>(){
			public int compare(String s1,String s2){
				return s1.length()-s2.length();
			}
		});  
		for(String s:strs){
			System.out.print(s+" ");
		} 
	}
}
