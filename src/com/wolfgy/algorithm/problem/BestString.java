package com.wolfgy.algorithm.problem;
/**
 * Problem Description</br >
 * Given a string, you use some letters or digits to creat a new string, this new string have three properties. </br >
 * 1. any two adjacent letter aren't the same. </br >
 * 2. the new string have the biggest length. </br >
 * 3. the new string have the biggest lexicographical ordering.</br >
 * </br >
 * Input:</br >
 * The input consists of multiple test cases. Each test case contain a string, the string is consist of 'a'~'z', 'A' - 'Z' and '0' - '9'. the length of string is not exceed 500.</br >
 * Output:</br >
 * For each case, print the new string.</br >
 * </br >
 * Sample Input:</br >
 * 2</br >
 * abaa</br >
 * 001</br >
 * Sample Output:</br >
 * aba</br >
 * 010</br >
 */
public class BestString {

	public static void main(String[] args) {
		String input = "abavsbcddab";
		BestString bestString = new BestString();
		String output = bestString.handle(input);
		System.out.println("BestString:"+output);
	}
	
	
	
	private String handle(String input){
		char[] characters = input.toCharArray();
		characters = permutationWithDictionary(characters);//对数组进行字典排序获取最大序列
		//保证相邻字符不相同
		StringBuffer sb = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		for (char c : characters) {
			if (sb.length()>0) {
				if (c != sb.charAt(sb.length()-1)) {
					sb.append(c);
				}else{
					temp.append(c);
				}
			}else{
				sb.append(c);
			}
		}
		if (temp.length()>0) {
			String tempStr = handle(temp.toString());//递归调用
			if (sb.charAt(sb.length()-1) != tempStr.charAt(0)) {
				sb.append(tempStr);
			}		
		}
		return sb.toString();
	}
	
	//获取字典排序的最大序列
	private  char[] permutationWithDictionary(char[] characters){
		while(true){
			for (int i = characters.length-1; i >=0; i--) {
				for (int j = 0; j < i; j++) {
					if (characters[i]>characters[j]) {
						char temp = characters[i];
						characters[i] = characters[j];
						characters[j] = temp;
						break;
					}
				}
			}
			//从右向左找到第一个非递增的元素,若找不到则返回结果
			for(int k=characters.length-2;k>=0;k--){	
                if(characters[k]<characters[k+1]){
                    break;                   
                }else if(k==0){
                    return characters;
                }
            }  

	    }
	}
	
}
