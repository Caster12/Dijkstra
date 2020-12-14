import java.util.ArrayDeque;
import java.util.ArrayList;

public class Graph {
	
	GraphNode[] node;
	int size;
	ArrayList<Edge> EdgeList = new ArrayList<Edge>();
	
	
	public Graph(int n) {
		size = n;
		node = new GraphNode[size];
		for(int i=0; i<n; i++) {
			node[i] = new GraphNode(i);
		}
	}
	
	public void addEdge(int from, int to, int w) {
		node[from].adjList.add(node[to]);
		node[to].adjList.add(node[from]);
		Edge e = new Edge(node[from],node[to],w);
		Edge e1 = new Edge(node[to],node[from],w);
		
		EdgeList.add(e);
		EdgeList.add(e1);
		
		
	}
	
	public void print() {
		for(int i=0; i<this.size; i++) {
			System.out.print(i+": ");
			node[i].print();
			System.out.println();
		}
	}
	
	public void reset() {
		for(int i=0; i<size; i++) {
			node[i].visited = false;
			node[i].d = Integer.MAX_VALUE;
			node[i].reset();
		}
	}
	

	
	public void Dijkstra(int i) {
		reset();
		
		ArrayDeque<GraphNode> q = new ArrayDeque<GraphNode>();
		
		q.add(node[i]);
		node[i].visited = true;
		node[i].d = 0;		
		node[i].Dijkstra(q,EdgeList);
		
		
	}
	
	public void ShortestPath(int s) {
		Dijkstra(s);
		
		 
			if(node[size-1].d==Integer.MAX_VALUE) {
				System.out.println("NO PATH EXIST");
			}
			else {
				System.out.println("Shortest path from "+node[s].label+" to "+node[size-1].label+": "+node[size-1].d);
			}
			
		
		
	}

}
