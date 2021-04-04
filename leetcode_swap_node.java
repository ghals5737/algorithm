public class leetcode_swap_node {
  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
  class Solution {
      public void swap(ListNode head){
          ListNode next=head.next;
          if(next==null)return;
          ListNode nnext=next.next;          
          int tmp=head.val;          
          head.val=next.val;
          next.val=tmp;
          if(nnext==null)return;
          swap(nnext);
      }
      public ListNode swapPairs(ListNode head) {
          swap(head);
          return head;
      }
  }
    public static void main(String[] args) {
        
    }    
}
