package com.wolfgy.algorithm.base;
import java.util.Arrays;
/**
 * 
 * 字典排序
 */
public class LexicographicalOrdering {
	
	public static void main(String[] args) {
		LexicographicalOrdering lexicographicalOrdering = new LexicographicalOrdering();
		char[] result = lexicographicalOrdering.PermutationWithDictionary(new char[]{'1','a','d'});
		for (int i = 0; i < result.length; i++) {
			System.out.println("result["+i+"]:"+result[i]);
		}
	}
	
	public  char[] PermutationWithDictionary(char chs[])
    {
        Arrays.sort(chs);
        //先对数组的元素进行依次排序
        while(true)
        {
            System.out.println(chs);
            int j=chs.length-1;
            int index=0;
            for(j=chs.length-2;j>=0;j--)
            {
                if(chs[j]<chs[j+1])
                {
                    index=j;
                    break;
                    //从右向左找到第一个非递增的元素
                }
                else if(j==0){
                    return chs;
                }
            }           

            for(j=chs.length-1;j>=0;j--)
            {
                if(chs[j]>chs[index])
                    break;
                    //从右向左找到第一个比非递增元素大的元素
            }
                Swap(chs,index,j);
                //交换找到的两个元素
                System.out.println("交换后："+chs.toString());
                Reverse(chs,index+1);
                //对非递增元素位置后面的数组进行逆序排列
                System.out.println("逆序排列后："+chs.toString());
        }       
    }
    private static void Reverse(char chs[],int i)
    {
        int k=i,j=chs.length-1;
        while(k<j)
        {
            Swap(chs,k,j);
            k++;
            j--;
        }
    }

    private static void Swap(char chs[],int i,int j)
    {
        char temp;
        temp=chs[i];
        chs[i]=chs[j];
        chs[j]=temp;
    }
}
