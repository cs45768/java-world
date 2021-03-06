package cn.zch.innerclasses;

import java.util.Arrays;

/**
* 静态成员类
* 
* String类的CaseInsensitiveComparator比较器，该静态成员类提供了String类型忽略字符大小写的比较方法。
* 
* @author zch
*/
public class StaticMemberClassTest {
	public static void main(String[] args) { 
		String[] strs={"ab","Ab","CC","abc"};   
		Arrays.sort(strs);//默认排序规则（大小写敏感）
		for(String s:strs){
			System.out.print(s+" ");
		} 
		System.out.println();
		Arrays.sort(strs,String.CASE_INSENSITIVE_ORDER);//大小写不敏感的排序规则
		for(String s:strs){
			System.out.print(s+" ");
		} 
	}
}
