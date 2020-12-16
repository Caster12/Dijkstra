import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner; 

public class Test {
	public static void main(String[]args) throws IOException{
		
		
		System.out.println();
		Scanner in = new Scanner(System.in);
		System.out.println("Please add the path of your file:");
		String s = in.nextLine();
		
		File file = new File(s); 
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String line1 = br.readLine();
		String[] str = line1.trim().split(" ");
		
		int n = Integer.parseInt(str[0]);
		Graph g = new Graph(n);
		int l = Integer.parseInt(str[1]); 
		
		
		 String st; 
		 while ((st = br.readLine())!= null) {
			 
			 String[] a = st.split(" "); 
			 g.addEdge(Integer.parseInt(a[0])-1,Integer.parseInt(a[1])-1,Integer.parseInt(a[2]));

		 } 
		
		
//		System.out.println();
//		
//		g.print();
		
		System.out.println();
		
		g.ShortestPath(0);
		
	}
	
}
