# Search in Rotated Sorted Array

### Problem 
An integer array `nums` is sorted in ascending order with **distinct** values

Prior to being passed to the solution function, `nums` is **possibly rotated** at an unknown pivot index `k` such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). 

For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` after the possible rotation and an integer `target`, return the *index* of `target` if it is in nums, or `-1` if it is not in nums.

You must write an algorithm with `O(log n)` runtime complexity.

### Example
  - **Input:** `nums` = `[4,5,6,7,0,1,2]`, `target` = `0`
  - **Output:** `4`

### Thoughts
- `O(log n)` => binary search
  - Binary search is designed to work with sorted arrays, and `nums` is semi-sorted
  - Maybe we can use binary search with some adjustments

### Implementation
- Uses modified binary search algo
- Checks whether each 'half' created by traditional BS algo is sorted as well as whether the target is between the upper and lower bounds of each 'half'
  - If a half is not sorted (i.e. the pivot index exists in said half), then we check the other half
    - If the target is not in said other half, we move the mid point to the corresponding upper or lower bound (+/-1)

### Complexity
- Time Complexity: `O(log n)`
- Space Complexity: `O(1)` 