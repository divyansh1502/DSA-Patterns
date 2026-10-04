public class DetectCycle {
    public static void main(String[] args) {

    // Create nodes
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    // Create cycle: 4 -> 2
    head.next.next.next.next = head.next;

    System.out.println(hasCycle(head)); // true
}
    public static boolean hasCycle(ListNode head) {
        
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
    static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
}
