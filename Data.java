import java.util.*;
import java.util.Random; 

public class Data {
	public static void main(String[]args) {
		
		int max_vertex = 20;
		int max_edges = 200;
		int max_weight = 200;
		
		Random rand = new Random(); 
		
		Set<Pair> container  = new HashSet<Pair>();  
		
		int num = 1+ rand.nextInt(max_vertex); 
		int num_edge = 1+rand.nextInt(max_edges); 
		
		while(num_edge> (num*(num-1))/2) 			
			num_edge = 1+rand.nextInt(max_edges); 
		
		System.out.format("%d %d%n", num,num_edge);
		
		
		for (int j=1; j<=num_edge; j++) {
			int a = 1+ rand.nextInt(num); 
			int b = 1+ rand.nextInt(num); 
			Pair p = new Pair(a,b);
			Pair reverse_p = new Pair(b,a);
			
			while (container.contains(p) || container.contains(reverse_p)){
				a = 1+ rand.nextInt(num); 
				b = 1+ rand.nextInt(num); 
				p = new Pair(a,b);
				reverse_p = new Pair(b,a);

			}
			container.add(p);
			
			
		}
		
		for (Pair value : container) {
			int wt = 1+ rand.nextInt(max_weight);
			
			System.out.format("%d %d %d\n", value.get_first(), value.get_second(), wt);
		}
		
		
		
		
		
	}

}
