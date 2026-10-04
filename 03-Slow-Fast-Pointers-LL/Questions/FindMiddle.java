public class FindMiddle {
    public static void main(String[] args) {

    // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    // Find middle
    ListNode middle = middleNode(head);

    System.out.println("Middle node: " + middle.val);
}
    public static ListNode middleNode(ListNode head) {
        if(head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
