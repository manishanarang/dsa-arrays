class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

      for(int i=0;i<numCourses;i++)
            courseDict.put(i, new ArrayList<>());
    for (int[] relation : prerequisites) {
      courseDict.computeIfAbsent(relation[1], k -> new ArrayList<>()).add(relation[0]);
    }

    Set<Integer> visited = new HashSet<>();

    for (int i = 0; i < numCourses; ++i) {
      if (isCyclic(i, courseDict, visited, new HashSet<>()))
        return false;
    }

    return true;
  }


  protected boolean isCyclic(
      Integer i, HashMap<Integer, List<Integer>> courseDict,
      Set<Integer> visited, Set<Integer> cycle) {

    if (cycle.contains(i))
      return true;
      
    if(visited.contains(i)) return false;
      
    cycle.add(i);

    for (Integer child : courseDict.get(i)) {
            if(isCyclic(child, courseDict, visited, cycle)) return true;
        }
    
    cycle.remove(i);
    visited.add(i);

    return false;
}
}