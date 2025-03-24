package src.main.java.solutions;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
  // First solution, 48/54 test cases, time limit exceeded
  public boolean canFinishV1(int numCourses, int[][] prerequisites) {
    @SuppressWarnings("unchecked")
    List<Integer>[] courseGraph = new List[numCourses];
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      courseGraph[i] = new ArrayList<>();
    }
    for (int[] prereq : prerequisites) {
      int u = prereq[1];
      int v = prereq[0];
      courseGraph[u].add(v);
    }

    for (int i = 0; i < numCourses; ++i) {
      if (hasCycle(courseGraph, i, visited)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasCycle(List<Integer>[] graph, int u, boolean[] visited) {
    if (visited[u] == true) {
      return true;
    } else {
      visited[u] = true;
      for (int v : graph[u]) {
        if (hasCycle(graph, v, visited)) {
          return true;
        }
      }
      // Since we did not find a cycle for a given u, set it back to unvisited;
      // multiple connections to a given vertex are allowed, just not cycles
      visited[u] = false;
    }
    return false;
  }

  public boolean canFinishV2(int numCourses, int[][] prerequisites) {
    @SuppressWarnings("unchecked")
    List<Integer>[] courseGraph = new ArrayList[numCourses];
    int[] state = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      courseGraph[i] = new ArrayList<>();
    }
    for (int[] prereq : prerequisites) {
      courseGraph[prereq[1]].add(prereq[0]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (hasCycle(courseGraph, i, state)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasCycle(List<Integer>[] graph, int u, int[] state) {
    // Use a "state" array, to reduce unnecessary re-checking that comes with a
    // boolean[]
    if (state[u] == 1) {
      return true;
    }
    if (state[u] == 2) {
      return false;
    }
    state[u] = 1;
    for (int v : graph[u]) {
      if (hasCycle(graph, v, state)) {
        return true;
      }
    }
    state[u] = 2;
    return false;
  }
}
