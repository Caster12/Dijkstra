import java.util.ArrayDeque;
import java.util.ArrayList;

public class GraphNode {
	
	int label;
	ArrayList<GraphNode> adjList;
	boolean visited;
	public int d;
	
	GraphNode(int l){
		label = l;
		adjList = new ArrayList<GraphNode>();
		d = Integer.MAX_VALUE;
	}
	
	
	public void print() {
		for(int j=0; j<adjList.size(); j++) {
			System.out.print(adjList.get(j).label+"-->");
		}
		System.out.print("null");
	}
	
	public void reset() {
		
		for(int j = 0; j<adjList.size(); j++){
				adjList.get(j).visited = false;
				adjList.get(j).d = Integer.MAX_VALUE;
		}
	}
		
	
	public void Dijkstra(ArrayDeque<GraphNode> q,ArrayList<Edge> EdgeList ) {
		
		while(!q.isEmpty()) {
			GraphNode x = q.remove();
			
			for(int j=0; j<x.adjList.size(); j++) {
				GraphNode y = x.adjList.get(j);
				
				if(!y.visited) {
					q.add(y);
					y.visited = true;
					
					for(int i=0; i<EdgeList.size();i++) {
						if(EdgeList.get(i).from.label==x.label && EdgeList.get(i).to.label==y.label) {								
							y.d = (EdgeList.get(i).weight-x.d)+x.d;
						}
					}
					
					
				}
				
				else if (y.visited) {
					
					for(int i=0; i<EdgeList.size();i++) {
						if(EdgeList.get(i).from.label==x.label && EdgeList.get(i).to.label==y.label) {
							
							if(y.d > (EdgeList.get(i).weight-x.d)+x.d)
								y.d = (EdgeList.get(i).weight-x.d)+x.d;
						}
					}
				}
				
			}
		}
		
	}
	
}
