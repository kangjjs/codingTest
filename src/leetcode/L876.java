package leetcode;

class L876 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode cur = head;
        ListNode ans = head;
        int cnt = 0;

        while (cur != null) {
            cnt++;

            if(cnt%2==0){
                ans = ans.next;
            }

            cur = cur.next;
        }

        return ans;
    }
}
