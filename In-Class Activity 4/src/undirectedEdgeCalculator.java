import java.util.ArrayList;
import java.util.List;

public class undirectedEdgeCalculator {

        private List<List<Integer>> adjacencyList;
        private int numVertices;

        private int numDegree;

        public undirectedEdgeCalculator(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new ArrayList<>(numVertices);


            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new ArrayList<>());
                System.out.println(adjacencyList);
            }

        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
            numDegree += 1;
            System.out.println(adjacencyList);
        }





    public static void main(String[] args) {

        undirectedEdgeCalculator graph = new undirectedEdgeCalculator(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);

        int edges = (graph.numVertices * graph.numDegree) / 2;

        System.out.println(edges);

    }
}
