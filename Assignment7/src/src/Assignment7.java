import java.util.*;

public class Assignment7 {

 private Map<String, List<String>> adjacencyList;

 public Assignment7() {
  adjacencyList = new HashMap<>();
 }

 public void addEdge(String course, String prerequisite) {
  if (!course.equals(prerequisite)) {
   adjacencyList.computeIfAbsent(course, k -> new ArrayList<>()).add(prerequisite);
  }
 }

 public List<String> findPrerequisites(String course) {
  List<String> prerequisites = new ArrayList<>();
  Set<String> visited = new HashSet<>();
  dfs(course, visited, prerequisites, false);
  return prerequisites;
 }

 private void dfs(String course, Set<String> visited, List<String> prerequisites, boolean includeCourse) {
  if (visited.contains(course)) {
   return;
  }
  visited.add(course);
  List<String> prerequisitesList = adjacencyList.getOrDefault(course, Collections.emptyList());
  for (String prerequisite : prerequisitesList) {
   dfs(prerequisite, visited, prerequisites, true);
  }
  if (includeCourse) {
   prerequisites.add(course);
  }
 }

 public static void main(String[] args) {
  Assignment7 graph = new Assignment7();

  graph.addEdge("INCS 620", "CSCI 509");
  graph.addEdge("INCS 712", "CSCI 651");
  graph.addEdge("INCS 712", "CSCI 615");
  graph.addEdge("INCS 745", "CSCI 620");
  graph.addEdge("INCS 745", "INCS 615");
  graph.addEdge("INCS 745", "INCS 615");
  graph.addEdge("INCS 741", "CSCI 507");
  graph.addEdge("INCS 741", "CSCI 504");
  graph.addEdge("INCS 715", "INCS 615");
  graph.addEdge("INCS 775", "INCS 745");
  graph.addEdge("INCS 870", "ESLI 593");
  graph.addEdge("INCS 870", "INCS 741");
  graph.addEdge("INCS 870", "CSCI 620");
  graph.addEdge("INCS 870", "INCS 615");

  List<String> prerequisites = graph.findPrerequisites("INCS 712");
  System.out.println("Prerequisites for INCS 712: " + prerequisites);

  prerequisites = graph.findPrerequisites("INCS 745");
  System.out.println("Prerequisites for INCS 745: " + prerequisites);

  prerequisites = graph.findPrerequisites("INCS 870");
  System.out.println("Prerequisites for INCS 870: " + prerequisites);
 }
}
