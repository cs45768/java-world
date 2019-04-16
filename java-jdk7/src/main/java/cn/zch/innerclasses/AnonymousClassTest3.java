package cn.zch.innerclasses;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

public class AnonymousClassTest3 {
	//将int[]转换成的List<Integer>的静态工厂方法
	static List<Integer> intArrayAsList(final int[] a ){
		if(a==null){
			throw new NullPointerException();
		}
		return new AbstractList<Integer>(){
			@Override
			public Integer get(int i){
				return a[i];
			}
			@Override
			public Integer set(int i,Integer value){
				int oldValue=a[i];
				a[i]=value;
				return oldValue;
			}
			@Override
			public int size(){
				return a.length;
			}
		} ;
	}
	public static void main(String[] args) {  
		int[] a={1,2,3,45,2,1};
		List<Integer> list=AnonymousClassTest3.intArrayAsList(a);
		Collections.sort(list);
		for(int i:list){
			System.out.print(i+" ");
		}
	}
}
