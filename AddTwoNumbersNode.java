/**
   PROBLEM : You are given two non-empty linked lists representing two non-negative integers. 
			 The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
			 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

		 	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
			Output: 7 -> 0 -> 8
**/


/** Main Entry **/
public class AddTwoNumbersNode {

	public static void main(String[] args){
	
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers(l1, l2);
		
		System.out.println("Solution : [ " + result.val + " , " + result.next.val + " ] " );
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        int sum = sum(l1.val, l2.val);
        int rest = restOf(l1.val, l2.val);
        ListNode lvResult = new ListNode(sum);
    
        if(l1.next != null && l2.next != null){
            l1.next.val += rest;
            lvResult.next = addTwoNumbers(l1.next, l2.next);
        }else if(l1.next != null){
            l1.next.val += rest;
            lvResult.next = addTwoNumbers(l1.next, new ListNode(0));
        }else if(l2.next != null) {
            l2.next.val += rest;
            lvResult.next = addTwoNumbers(l2.next, new ListNode(0));
        }else if(rest != 0){
            lvResult.next = new ListNode(rest);
        }
    
        return lvResult;
    }

    public int restOf(int a, int b){
    
        return a + b >= 10 ? 1 : 0;
    }

    public int sum(int a, int b){
        return (a + b) % 10;
    }
}
