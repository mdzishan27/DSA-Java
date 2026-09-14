/*
    Problem: Rectangle Overlap
    Difficulty: Easy

    Intuition:
    Instead of checking directly whether two rectangles overlap,
    check the 4 cases where they do NOT overlap.

    A rectangle does not overlap if it is completely:

    1. Left of the other rectangle:
       rec1[2] <= rec2[0]

    2. Right of the other rectangle:
       rec1[0] >= rec2[2]

    3. Below the other rectangle:
       rec1[3] <= rec2[1]

    4. Above the other rectangle:
       rec1[1] >= rec2[3]

    If any one of these conditions is true, return false
    because the rectangles are separated.

    If none of these conditions is true, the rectangles
    must overlap, so return true.

    Key Idea:
    Check for "NO OVERLAP" conditions first.
    If no separation exists, then there is an overlap.

    Time: O(1)
    Space: O(1)
*/

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        //Rectangle 1 is completely  to the left of rectangle 2
        if(rec1[2] <= rec2[0]) return false;

        //Rectangle 1 is completely to the right of rectangle 2
        if(rec1[0] >= rec2[2]) return false;

        //Rectangle 1 is completely below  rectangle 2
        if(rec1[3] <= rec2[1]) return false;

        //Rectangle 1 is completely above rectangle 2
        if(rec1[1] >= rec2[3]) return false;


        //if none of above, rectangles overlap
        return true;


    }
}
