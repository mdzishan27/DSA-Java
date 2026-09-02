// ### Approach

// * Traverse the linked list from **left to right** and build the decimal value step by step.
// * Maintain a variable `binary` to store the decimal value of the binary number processed so far.
// * For every node, use:

//  
//   binary = binary * 2 + head.val;

// * Multiplying by `2` shifts the existing binary number one position to the left, making space for the new bit.
// * Then add the current bit (`0` or `1`).
// * Continue until all nodes are processed.
// * The final value of `binary` is the decimal representation of the given binary linked list.

// ### Example

// For:

// 1 → 0 → 1 → 1


// Dry run:


// 0
// ↓
// 0 × 2 + 1 = 1
// ↓
// 1 × 2 + 0 = 2
// ↓
// 2 × 2 + 1 = 5
// ↓
// 5 × 2 + 1 = 11
// ```

// Therefore:


// 1011₂ = 11₁₀


// ### Complexity

// * **Time:** `O(n)` — traverse the linked list once.
// * **Space:** `O(1)` — only one variable is used apart from the input linked list.


class Solution {
    public int getDecimalValue(ListNode head) {
      ListNode temp = head;
        int binary = 0;
        while(temp != null){
            binary = binary*2 + temp.val;
            temp = temp.next;
        }
        return binary;
    }
