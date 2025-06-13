# Add Binary

### Problem
Given two binary strings `a` and `b`, return their sum as a binary string.

### Example
- **Input:** `a = "11"`, `b = "1"`
- **Output:** `"100"`

### Thoughts
- Need to handle binary addition with carry
- Process strings from right to left
- Handle strings of different lengths
- Need to account for final carry if present

### Implementation
- Use two pointers starting from end of both strings
- Add digits and carry, compute new carry
- Build result string from right to left
- Handle remaining digits if strings are different lengths
- Add final carry if present

### Complexity
- Time Complexity: `O(max(len(a), len(b)))` where we process each digit once
- Space Complexity: `O(max(len(a), len(b)))` for the result string 