package cn.zch.innerclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
* 静态成员类
* HashMap中的静态成员类Entry，该类代表哈希映射表的键值对，与他的外围类一起使用。
* 
* @author zch
*/
public class EntryStaticMemberClass {
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
		for(Entry<Integer, Integer> entry:countMap.entrySet()){
			System.out.println("元素："+entry.getKey()+" 出现了："+entry.getValue()+"次");
		} 
	} 
}
