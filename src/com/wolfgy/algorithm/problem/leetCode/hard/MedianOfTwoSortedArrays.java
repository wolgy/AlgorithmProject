package com.wolfgy.algorithm.problem.leetCode.hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n
 * respectively.</br >
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).</br >
 *
 * Example 1: nums1 = [1, 3] nums2 = [2]</br >
 * The median is 2.0 </br >
 * 
 * Example 2: nums1 = [1, 2] nums2 = [3, 4]</br >
 * The median is (2 + 3)/2 = 2.5</br >
 */
@SuppressWarnings("unused")
public class MedianOfTwoSortedArrays {
	/*
	 * input:[],[1]
	 * input:[],[2,3]
	 * input:[3,4],[]
	 * input:[],[1,2,3,4]
	 * input:[1,2,3],[1,2]
	 * input:[2,2,2,2],[2,2,2]
	 * input:[1,2],[3,4]
	 * input:[3],[1,2]
	 */
	public static void main(String[] args) {
		MedianOfTwoSortedArrays ob = new MedianOfTwoSortedArrays();
		System.out.println(ob.findMedianSortedArrays_1_2(new int[]{1,2,3,4},new int[]{2,4,6,8}));
	}

	/**
	 * 
	 * <p>
	 * Description:失败算法<br />
	 * </p>
	 * @deprecated
	 * @author wugy
	 * @version 0.1 2017年12月27日
	 * @param nums1
	 * @param nums2
	 * @return
	 * double
	 */
	private double findMedianSortedArrays_1_0_failed(int[] nums1, int[] nums2) {
		int i = nums1.length > 0 ? 0 : -1;
		int j = nums2.length > 0 ? nums2.length-1 : -1;
		if (i == -1) {
			if (j == -1) {
				return 0;
			} else {
				return getMedianOfOneArray(nums2);
			}
		} else {
			if (j == -1) {
				return getMedianOfOneArray(nums1);
			} else {
				while(true){
					if (nums1[i]>nums2[j]) {
						if (i>0 && j<nums2.length-1) {
							i--;
							j++;
							if (nums1[i]<=nums2[j]) {
								return (nums1[i]+nums2[j])/2.0f;
							}
						}else if(i==0 && j<nums2.length-1){
							i = nums2.length-1;
							while(true){
								if (i==j) {
									return nums2[i];
								}else if(i==j+1){
									return (nums2[i]+nums2[j])/2.0f;
								}
								i--;
								j++;
							}
						}else if(i>0 && j==nums2.length-1){
							j = 0;
							while(true){
								if (i==j) {
									return nums1[i];
								}else if(i==j+1){
									return (nums1[i]+nums1[j])/2.0f;
								}
								i--;
								j++;
							}
						}else{
							return (nums1[i]+nums2[j])/2.0f;
						}
					}else if(nums1[i]<nums2[j]){
						if (i<nums1.length-1 && j>0) {
							i++;
							j--;
							if (nums1[i]>=nums2[j]) {
								return (nums1[i]+nums2[j])/2.0f;
							}
						}else if(i==nums1.length-1 && j>0){
							i = 0;
							while(true){
								if (i==j) {
									return nums2[i];
								}else if(i==j-1){
									return (nums2[i]+nums2[j])/2.0f;
								}
								i++;
								j--;
							}
						}else if(i<nums1.length-1 && j==0){
							j = nums1.length-1;
							while(true){
								if (i==j) {
									return nums1[i];
								}else if(i==j-1){
									return (nums1[i]+nums1[j])/2.0f;
								}
								i++;
								j--;
							}
						}else{
							return (nums1[i]+nums2[j])/2.0f;
						}
					}else{
						return nums1[i];
					}
				}
			}
		}
	}
	private double getMedianOfOneArray(int[] nums) {
		double result;
		int mid = nums.length/2;
		if ((nums.length % 2) == 0) {
			result = (nums[mid] + nums[mid - 1]) / 2.0f;
		} else {
			result = nums[mid];
		}
		return result;

	}
	
	/**
	 * 
	 * <p>
	 * Description:1.1版本，合并数组寻求中位数<br />
	 * Runtime:61ms,87ms,89ms,time limit exceeded,57ms,79ms
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月27日
	 * @param nums1
	 * @param nums2
	 * @return
	 * double
	 */
	private double findMedianSortedArrays_1_1(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length+nums2.length];
		for (int i = 0,j = 0,k=0; i < nums.length; i++) {
			if (j<nums1.length && k<nums2.length) {
				if (nums1[j]<nums2[k]) {
					nums[i] = nums1[j++];
				}else{
					nums[i] = nums2[k++];
				}
			}else if(j==nums1.length && k<nums2.length){
				nums[i] = nums2[k++];
			}else if(j<nums1.length && k==nums2.length){
				nums[i] = nums1[j++];
			}
		}
		
		int mid = nums.length/2;
		if ((nums.length % 2) == 0) {
			return (nums[mid] + nums[mid - 1]) / 2.0f;
		} else {
			return nums[mid];
		}
		
	}
	
	/**
	 * 
	 * <p>
	 * Description:1.2版本，二分合并数组寻求中位数<br />
	 * Runtime:76ms,98ms,91ms,89ms,89ms,71ms
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月27日
	 * @param nums1
	 * @param nums2
	 * @return
	 * double
	 */
	private double findMedianSortedArrays_1_2(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length+nums2.length];
		int i = 0,j = 0,k=0,l=nums.length-1,m=nums1.length-1,n=nums2.length-1;
		while(true){
			if (nums1.length>0 && nums2.length>0) {
				if (j<nums1.length && k<nums2.length) {
					if (nums1[j]<nums2[k]) {
						nums[i] = nums1[j++];
					}else{
						nums[i] = nums2[k++];
					}
				}else if(j==nums1.length && k<nums2.length){
					nums[i] = nums2[k++];
				}else if(j<nums1.length && k==nums2.length){
					nums[i] = nums1[j++];
				}
				
				if (m>=0 && n>=0) {
					if (nums1[m]>nums2[n]) {
						nums[l] = nums1[m--];
					}else{
						nums[l] = nums2[n--];
					}
				}else if(m==-1 && n>=0){
					nums[l] = nums2[n--];
				}else if(m>=0 && n==-1){
					nums[l] = nums1[m--];
				}
				if (i+1==l || i==l) {
					break;
				}
				i++;
				l--;
			}else if(nums1.length==0 && nums2.length>0){
				if (nums2.length==1) {
					return nums2[0];
				}
				nums[i++] = nums2[k++];
				nums[l--] = nums2[n--];
				if (i==l+1 || i-2==l) {
					break;
				}
			}else if(nums1.length>0 && nums2.length==0){
				if (nums1.length==1) {
					return nums1[0];
				}
				nums[i++] = nums1[j++];
				nums[l--] = nums1[m--];
				if (i==l+1 || i-2==l) {
					break;
				}
			}else{
				return 0f;
			}
		}
		
		int mid = nums.length/2;
		if ((nums.length % 2) == 0) {
			return (nums[mid] + nums[mid - 1]) / 2.0f;
		} else {
			return nums[mid];
		}
		
	}
	
	/**
	 * 
	 * <p>
	 * Description:截至此刻LeetCode上的最优解<br />
	 * Runtime:[official:55ms][test:86ms,90ms,83ms,92ms,84ms,58ms]<br />
	 * PS:当nums1,nums2均为空时。此方法会报错。
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月28日
	 * @param nums1
	 * @param nums2
	 * @return
	 * double
	 */
	private double findMedianSortedArrays_best(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) {
            return findMedianSortedArrays_best(nums2,nums1);
        }
        if(n1 == 0)
            return (n2%2==0)?(double)(nums2[n2/2]+nums2[(n2/2)-1])/2 : nums2[n2/2];

        int l=0,r=n1;
        
        while(l<=r) {
            int partX = (l+r)/2,
            partY=((n1+n2+1)/2)-partX;
            
            int leftX = (partX==0)?Integer.MIN_VALUE:nums1[partX-1];
            int rightX = (partX==n1)?Integer.MAX_VALUE:nums1[partX];
            int leftY = (partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            int rightY = (partY==n2)?Integer.MAX_VALUE:nums2[partY];
            
            if(leftX <= rightY && leftY <= rightX) {
               if((n1+n2) % 2 == 0) {
                    int res = Math.max(leftX,leftY);
                    res+=Math.min(rightX,rightY);
                    return (double)res/2;
                }
                else
                    return Math.max(leftX,leftY);
            } else if(leftX > rightY) {
                r=partX-1;
            } else 
                l=partX+1;
        }
       return -1;
    }
}
