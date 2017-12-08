package com.wolfgy.algorithm.problem.leetCode.medium;

/**
 * 
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.<br />
 * <br />
 * Examples:<br />
 * Given "abcabcbb", the answer is "abc", which the length is 3.<br />
 * Given "bbbbb", the answer is "b", with the length of 1.<br />
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.<br />
 * </p>
 * @title LongestSubstringWithoutRepeatingCharacters.java
 * @package com.wolfgy.algorithm.problem.leetCode.medium 
 * @author wugy
 * @version 0.1 2017年12月8日
 */
@SuppressWarnings("unused")
public class LongestSubstringWithoutRepeatingCharacters {

	/*
	 * Special inputs:
	 * 1. input:"abcabcbb"	expected output:3
	 * 2. input:""			expected output:0
	 * 3. input:"dvdf"		expected output:3
	 * 4. input:"ohvhjdml"	expected output:6
	 * 5. input:"au"		expected output:2
	 * 6. input:"bbbbb"		expected output:1
	 * 7. input:"aa"		expected output:1
	 */
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
		int maxLength = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring_1_1("ohvhjdml");
		System.out.println("result:"+maxLength);
	}
		
	/**
	 * 
	 * <p>
	 * Description:The first solution of me.<br />
	 * Runtime:90ms<br />
	 * Beats:12.61 % of java submissions.<br />
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月8日
	 * @param str
	 * @return
	 * int
	 */
	private int lengthOfLongestSubstring_1_0(String str){
		if (str==null || str.equals("")) {
			return 0;
		}
		String[] subs = new String[str.length()];
		int subsIndex = 0;
		String[] chars = str.split("");
		StringBuffer sb = new StringBuffer(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			if (!sb.toString().contains(chars[i])) {
				sb.append(chars[i]);
			}else if(sb.indexOf(chars[i]) != sb.length()-1){
				subs[subsIndex++] = sb.toString();
				sb.delete(0,sb.indexOf(chars[i])+1);
				sb.append(chars[i]);
			}else{
				subs[subsIndex++] = sb.toString();
				sb.delete(0, sb.length());
				sb.append(chars[i]);
			}
		}
		subs[subsIndex++] = sb.toString();
		int maxLength = subs[0].length();
		for (int i = 1; i < subs.length; i++) {
			if (subs[i] == null) {
				return maxLength;
			}
			if (subs[i].length() > maxLength) {
				maxLength = subs[i].length();
			}
		}
		return maxLength;
	}
	
	/**
	 * 
	 * <p>
	 * Description:The first improved version after studying other people's solutions.<br />
	 * </p>
	 * @author wugy
	 * @version 0.1 2017年12月8日
	 * @param str
	 * @return
	 * int
	 */
	private int lengthOfLongestSubstring_1_1(String str){
		//It's my own habit to check if the input is empty.
		if (str == null) {
			return 0;
		}
		char[] chars = str.toCharArray();
		if (chars.length<2) {
			return chars.length;
		}
		int maxLength = 0,spliter = 0,cur_len = 1;
		for (int i = 0; i < chars.length; i++) {
			for (int j = spliter ; j < i ; j++) {
				if (chars[i]==chars[j]) {
					spliter = j+1;
					maxLength = maxLength>i-spliter+1 ? maxLength : i-spliter+1;
					break;
				}
			}
		}
		if (spliter==0) {
			maxLength = maxLength > chars.length-spliter ? maxLength : chars.length-spliter;
		}
		return maxLength;
	}
	
	/**
	 * 
	 * <p>
	 * Description:The best solution on LeetCode by this time.<br />
	 * Runtime:35ms<br />
	 * </p>
	 * @version 0.1 2017年12月8日
	 * @param s
	 * @return
	 * int
	 */
    private int lengthOfLongestSubstring_best(String s) {
        char[] chars = s.toCharArray();
        if(2 > chars.length){
            return chars.length;
        }
        int max = 0;
        int split_at = 0;
        int cur_len = 1;
        for(int i=1;i<chars.length;i++){
            int j = split_at;
            for(;j<i;j++){
                if(chars[i] == chars[j]){
                    break;
                }
            }
            if(j < i){
                split_at = j+1;
                cur_len = i-j;
            }else{
                cur_len++;
            }
            if(cur_len > max) max = cur_len;
        }
        return max;
    }
}
