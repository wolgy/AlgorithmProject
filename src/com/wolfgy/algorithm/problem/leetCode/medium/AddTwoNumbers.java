package com.wolfgy.algorithm.problem.leetCode.medium;

/**
 * 
 * <p>
 * Description:<br />
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.<br />
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.<br />
 * <br />
 * Example:<br />
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)<br />
 * Output: 7 -> 0 -> 8<br />
 * Explanation: 342 + 465 = 807.<br />
 * </p>
 * @title AddTwoNumbers.java
 * @package com.wolfgy.algorithm.problem.leetCode.medium 
 * @author wugy
 * @version 0.1 2017年12月4日
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode node = addTwoNumbers.addTwoNumbers(addTwoNumbers.initData(new int[]{5}), addTwoNumbers.initData(new int[]{5}));
		while (node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = null;
    	ListNode returnListNode = null;
    	int nextValue=0;
    	while (l1!=null || l2!=null || nextValue != 0) {
    		
    		//防止l1或l2为空时出现NullPointerException
    		if (l1 == null) {
    			l1 = new ListNode(0);
			}
    		if (l2 == null) {
    			l2 = new ListNode(0);
			}
    		
			int value = l1.val+l2.val+nextValue;//获取输入的两个链表中储存的值与nextValue之和
			nextValue = value/10;//获取和的十位数
			ListNode listNode = new ListNode(value%10);
			if (pre != null) {
				pre.next=listNode;
			}else{
				returnListNode = listNode;
			}
			pre = listNode;
			l1 = l1.next;
			l2 = l2.next;
		}
    	return returnListNode;      
    }
    
    /**
     * Definition for singly-linked list.
     */
    private class ListNode {
    	int val;
    	ListNode next;
		ListNode(int x) { 
			this.val = x; 
		}
		
	}
    
    /**
     * 
     * <p>
     * Description:将给定数组转换成链表<br />
     * </p>
     * @author wugy
     * @version 0.1 2017年12月4日
     * @param i
     * @return
     * ListNode
     */
    private ListNode initData(int[] i){
    	ListNode pre = null;
    	for (int j = i.length-1; j >=0 ; j--) {
			ListNode listNode = new ListNode(i[j]);
			listNode.next = pre;
			pre = listNode;
		}
		return pre;
    	
    }
}
