package src.main.java.solutions;

public class MajorityElement {
  public int majorityElement(int[] nums) {
    // O(n) space
    // HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    // int majorityElement = 0;
    // int max = 0;
    // for (int i : nums) {
    // frequencyMap.put(i, frequencyMap.get(i) == null ?
    // 1 : frequencyMap.get(i) + 1);
    // System.out.println(frequencyMap);
    // if (frequencyMap.get(i) > max) {
    // max = frequencyMap.get(i);
    // majorityElement = i;
    // }
    // System.out.println(majorityElement);
    // }
    // return majorityElement;

    // O(1) space
    int majorityElement = 0;
    int elementCount = 0;
    for (int i : nums) {
      if (elementCount == 0) {
        majorityElement = i;
      }
      elementCount += (i == majorityElement ? 1 : -1);
    }
    return majorityElement;
  }
}
