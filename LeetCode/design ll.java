class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;

    public MyLinkedList() {
        head = null;
    }

    // Get value at index
    public int get(int index) {

        ListNode temp = head;

        for (int i = 0; i < index; i++) {

            if (temp == null)
                return -1;

            temp = temp.next;
        }

        return temp == null ? -1 : temp.val;
    }

    // Insert at head
    public void addAtHead(int val) {

        ListNode newNode = new ListNode(val);

        newNode.next = head;
        head = newNode;
    }

    // Insert at tail
    public void addAtTail(int val) {

        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at given index
    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode temp = head;

        for (int i = 0; i < index - 1; i++) {

            if (temp == null)
                return;

            temp = temp.next;
        }

        if (temp == null)
            return;

        ListNode newNode = new ListNode(val);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at given index
    public void deleteAtIndex(int index) {

        if (head == null)
            return;

        if (index == 0) {
            head = head.next;
            return;
        }

        ListNode temp = head;

        for (int i = 0; i < index - 1; i++) {

            if (temp == null)
                return;

            temp = temp.next;
        }

        if (temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
    }
}