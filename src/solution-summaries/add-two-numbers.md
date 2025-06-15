# Add Two Numbers

### Problem
Given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

### Example
- **Input:** `l1 = [2,4,3]`, `l2 = [5,6,4]`
- **Output:** `[7,0,8]`
- **Explanation:** 342 + 465 = 807

### Thoughts
- Need to handle linked list traversal
- Process digits from left to right (reverse order)
- Need to handle carry between digits
- Handle lists of different lengths
- Need to account for final carry if present

### Implementation
- Create dummy head node for result list
- Use two pointers to traverse both lists
- Add digits and carry, compute new carry
- Create new node for each digit in result
- Handle remaining digits if lists are different lengths
- Add final carry if present

### Complexity
- Time Complexity: `O(max(len(l1), len(l2)))` where we process each node once
- Space Complexity: `O(max(len(l1), len(l2)))` for the result list 