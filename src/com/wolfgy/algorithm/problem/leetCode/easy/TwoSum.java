package com.wolfgy.algorithm.problem.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.</br >
 *You may assume that each input would have exactly one solution, and you may not use the same element twice.</br >
 *</br >
 *Example:</br >
 *Given nums = [2, 7, 11, 15], target = 9,</br >
 *Because nums[0] + nums[1] = 2 + 7 = 9,</br >
 *return [0, 1].</br >
 */
public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] out = twoSum.twoSum_1_2(new int[]{-4444444,4,4444444,90}, 0);
		if (out != null) {
			System.out.println(out[0]+"-"+out[1]);
		}else{
			System.out.println("null");
		}
	}
	
	/**
	 * 
	 * <p>
	 * Description:我自己的第一个解决方案<br />
	 * 耗时：39ms
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月4日
	 * @param nums
	 * @param target
	 * @return
	 * int[]
	 */
    private int[] twoSum_1_0(int[] nums, int target) {
    	
    	int[] indices =new int[2];
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]+nums[j]==target) {
					indices[0]=i;
					indices[1]=j;
					return indices;
				}
			}
		}
		return null;
       
    }
    
    /**
     * 
     * <p>
     * Description:研究过别人代码以后的第二个改进版本<br />
     * 耗时：9ms
     * </p>
     * @author wugy
     * @version 1.1 2017年12月6日
     * @param nums
     * @param target
     * @return
     * int[]
     */
    private int[] twoSum_1_2(int[] nums, int target){
    	Map<Integer,Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {		
			int diff = target-nums[i];
			if (map.containsKey(diff)) {
				return new int[]{map.get(diff),i};
			}
			map.put(nums[i], i);
		}
		return null;
    	
    }
    
    /**
     * 
     * <p>
     * Description:研究过别人代码以后的第一个改进版本<br />
     * 耗时：9ms
     * </p>
     * @author wugy
     * @version 1.1 2017年12月6日
     * @param nums
     * @param target
     * @return
     * int[]
     */
    private int[] twoSum_1_1(int[] nums, int target){
    	Map<Integer,Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		//如果map中已存在当前值，则放弃储存key为当前值的下标
    		if (map.get(nums[i]) == null) {
    			map.put(nums[i], i);
			}		
			int diff = target-nums[i];
			Integer d = map.get(diff);
			if (d != null && d != i) {
				return new int[]{d,i};
			}
		}
		return null;
    	
    }
    
    /**
     * 
     * <p>
     * Description:截至此刻leetCode上的最优解<br />
     * 耗时：3ms<br />
     * </p>
     * 已发现2个无法通过的TestCase:<br />
     * 1.Input:[2222222,2222222],4444444;Output:[0,1]<br />
     * 2.Input:[-9,4,9,90],0;Output:[0,2]<br />
     * @deprecated
     * @version 0.1 2017年12月4日
     * @param nums
     * @param target
     * @return
     * int[]
     */
    private int[] bestTwoSum(int[] nums, int target) {
        int[] map = new int[20050];//完全无法理解为什么数组长度为20050。这种做法如果传入的数组中有比20050更大的值就挂了。已向leetCode提交TestCase
        int size = 4;
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + size] = (i + 1);
            int diff = target - nums[i + 1] + size;
            if (diff < 0) continue;
            int d = map[diff];
            if (d > 0)
                return new int[]{d - 1, i + 1};
        }
        return null;
    }

}
