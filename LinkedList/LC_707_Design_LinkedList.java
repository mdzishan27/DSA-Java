/*
Approach:

1. Maintain three variables:
   - head  → points to the first node.
   - tail  → points to the last node.
   - size  → keeps track of the number of nodes.

2. get(index):
   - First check whether the index is valid.
   - Traverse from head until reaching the required index.
   - Return the value of that node.

3. addAtHead(val):
   - Create a new node.
   - If the list is empty, both head and tail point to the new node.
   - Otherwise, connect the new node before head and update head.
   - Increase size.

4. addAtTail(val):
   - Create a new node.
   - If the list is empty, both head and tail point to it.
   - Otherwise, connect the new node after tail and update tail.
   - Increase size.

5. addAtIndex(index, val):
   - If index is invalid, do nothing.
   - If index == 0, add at head.
   - If index == size, add at tail.
   - Otherwise, traverse to the node before the required index
     and insert the new node between two nodes.
   - Increase size.

6. deleteAtIndex(index):
   - If index is invalid, do nothing.
   - If index == 0, delete the head.
   - Otherwise, traverse to the node before the required index
     and skip the node that needs to be deleted.
   - If the deleted node was the tail, update tail.
   - Decrease size.

7. deleteAtHead():
   - If the list is empty, do nothing.
   - Move head to head.next.
   - If the list becomes empty, set tail = null.
   - Decrease size.

Key Idea:
Handle the special cases first (empty list, head, tail, invalid index),
then perform the normal middle-node operation.

Time Complexity:
- get()          → O(n)
- addAtHead()    → O(1)
- addAtTail()    → O(1)
- addAtIndex()   → O(n)
- deleteAtIndex()→ O(n)
- deleteAtHead() → O(1)

Space Complexity: O(1) extra space
*/



class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size) return -1;
        
    
        ListNode temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        if(head == null) head = tail = temp;
        else {
            temp.next = head;
            head = temp;
        }
        size++;   
    }
    
    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);
        if(tail == null) head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {

        if(index < 0 || index > size) return;

        if(index == 0){
           addAtHead(val);
           return;
        } 

        if(index == size){
           addAtTail(val);
           return;
        } 

        ListNode temp = head;
        for(int i=1; i<=index-1; i++){
            temp = temp.next;
        }

        ListNode t = new ListNode(val);
        t.next = temp.next;
        temp.next = t;
        size++;
    }
    
    public void deleteAtIndex(int index) {

        if(index < 0 || index >= size) return;

        if(index == 0) {
            deleteAtHead();
            return;
        }
        ListNode temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        if(index == size-1) tail = temp;
        
        size--;
        

    }

    public void deleteAtHead(){
        if(head == null) return ; //0_size LL
        else {
            head = head.next;
        }

        if(head == null) tail = null; //1-Size LL
        
        size--;
    }
}

