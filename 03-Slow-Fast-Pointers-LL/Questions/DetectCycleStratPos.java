import java.util.List;

public class DetectCycleStratPos {
    public static void main(String[] args) {

        // Create linked list
        // 1 -> 2 -> 3 -> 4 -> 5
        //          ↑         ↓
        //          └─────────┘

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        // Find cycle starting node
        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at: " + cycleStart.val);
        } else {
            System.out.println("No cycle");
        }
    }
    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
