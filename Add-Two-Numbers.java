class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(l1!=null || l2!=null || carry==1){
            int sum = 0;
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum=sum+carry;
            carry = sum/10;
            // important step
            ListNode node = new ListNode(sum%10); // the value we'll get by moduloing it,  will become as new node so. add it to our list
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
