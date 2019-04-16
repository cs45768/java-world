package cn.zch.innerclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
* 非静态成员类
* 
* 非静态成员类的一种常见的用法是定义一个Adapter(适配器)，提供类的各种视图。
* 例如，Map接口的实现往往使用非静态成员类来实现它们的集合视图（Collection View），
* 这些集合视图由Map的keySet、entrySet和values方法返回。
* 非静态成员类，都可以直接访问外围类的实例属性（keySet、values和entrySet）。
* @author zch
*/
public class NoStaticMemberClassTest {
	public static void main(String[] args) { 
		int[] nums={1,3,3,2,1,5,4,3,8,2};
		Map<Integer,Integer> countMap=new HashMap<Integer,Integer>();
		for(int i:nums){
			if(countMap.get(i)==null){
				countMap.put(i, 1);
			}else{
				countMap.put(i, countMap.get(i)+1);
			}
		}
		System.out.print("键集合：");
		for(Integer i:countMap.keySet()){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.print("值集合：");
		for(Integer i:countMap.values()){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("建值对集合：");
		for(Entry<Integer, Integer> entry:countMap.entrySet()){
			System.out.println("建："+entry.getKey()+" 值："+entry.getValue());
		} 
	} 
}
