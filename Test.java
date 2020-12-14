import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
	public static void main(String[]args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
		
		String line1;
		line1 = stdin.readLine();
		String[] str = line1.trim().split(" ");
		
		int n = Integer.parseInt(str[0]);
		Graph g = new Graph(n);
		int l = Integer.parseInt(str[1]);
		
	
		
        String line; 
		for (int i = 0; i<l; i++) {  
			line = stdin.readLine();
			String[] strs = line.trim().split(" ");
			g.addEdge(Integer.parseInt(strs[0]),Integer.parseInt(strs[1]),Integer.parseInt(strs[2]));
		}
		
		System.out.println();
		
		g.print();
		
		System.out.println();
		
		g.ShortestPath(0);
		
	}
	
}
