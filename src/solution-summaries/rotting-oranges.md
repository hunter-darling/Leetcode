# Rotting Oranges

### Problem 
Given an `m x n` `grid` where each cell has one of 3 values:
- `0` : empty cell
- `1` : fresh orange
- `2` : rotten orange

Every minute, any fresh orange that is **4-directionally** adjacent to a rotten orange becomes rotten itself.

Return the *minimum number of minutes that must elapse until no cell has a fresh orange*. If this is not possible, return `-1`.

### Example
  - **Input:** `grid` = 
```
[
 [2,1,1],
 [1,1,0],
 [0,1,1]
]
```
  - **Output:** `4`

### Thoughts
- Needing to check 4-directionally => BFS
- Should use a Queue DS
- Init Q with initial rotten orange, pop through each, then add next/new rotten oranges to the Q, then pop through each of those, each pop through, we increment a unit of time
- Update grid cells in place (rot oranges)
- After Queue is completely empty, we may end up with an orange that is still fresh, so we'll need to keep track of fresh oranges

### Implementation
- Use a queue to track rotting oranges
- Maintain a count of fresh oranges
- Use a directions array for checking adjacent cells
- Return `-1` if fresh oranges count is `>1` after BFS completes

### Complexity
- Time Complexity: `O(m * n)` where m and n are the dimensions of the grid
- Space Complexity: `O(m * n)` for the queue in worst case