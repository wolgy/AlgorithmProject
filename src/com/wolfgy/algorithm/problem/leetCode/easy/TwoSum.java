package com.wolfgy.algorithm.problem.leetCode.easy;
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
		int[] out = twoSum.twoSum(new int[]{3,2,4}, 6);
		System.out.println(out);
	}
	
	/**
	 * 
	 * <p>
	 * Description:我自己的解决方案<br />
	 * 耗时：39ms
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月4日
	 * @param nums
	 * @param target
	 * @return
	 * int[]
	 */
    private int[] twoSum(int[] nums, int target) {
    	
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
     * Description:截至此刻leetCode上的最优解<br />
     * 耗时：3ms
     * </p>
     * @version 0.1 2017年12月4日
     * @param nums
     * @param target
     * @return
     * int[]
     */
    private int[] bestTwoSum(int[] nums, int target) {
        int[] map = new int[20050];
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
