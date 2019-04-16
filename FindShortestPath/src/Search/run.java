package Search;

import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;


import Helper.fillDigraph;
import Helper.food;
import Helper.lines;

public class run {

   private static List<Integer> dfs = new ArrayList<Integer>();

    
   private static List<String[]> b = new ArrayList<String[]>();
	

    
   private static    List<Integer> bfs = new ArrayList<Integer>();
    
   private static	List<String[]> a = new ArrayList<String[]>();	

//	public static void output(List<Integer> bfs, List<Integer> dfs, List<String[]> a, List<String[]> b) {
		public static void output() {

		Writer wr = null;
		List<String> index = lines.index();
//		System.out.println(index.get(3) + "     " +index.get(18) );

		try {
			File f = new File("data/a2_out.txt");
			wr = new BufferedWriter(new FileWriter(f));


	        bfs = BFSpath.pathway();
	        
			wr.write("BFS: ");
			int i = 0;
			for(  i = 0 ;i < bfs.size() - 1;i++) {
				String name = index.get(bfs.get(i)).toString();
				wr.write(name+", ");
				System.out.println(name);

			}
			
			
			String name = index.get(bfs.get(i)).toString();
			System.out.println(name + " ->>>>>>>>>");

			wr.write(name);
			wr.write("\r\n");
			wr.write("DFS: ");
			
			dfs = DFSpath.pathway();

			i = 0;
			for(  i = 0 ;i < dfs.size() - 1;i++) {
				name = index.get(dfs.get(i)).toString();
				wr.write(name+", ");
				System.out.println(name);

			}
			name = index.get(dfs.get(i)).toString();
			wr.write(name);
			wr.write("\r\n\nTable:\n");
			wr.write("BFS result: \n");
			a = food.run(bfs);
			for(  i = 0 ;i < bfs.size() - 1;i++) {
				name = index.get(bfs.get(i)).toString();
				
				wr.write(name+"          " + a.get(i)[1] + "    " + a.get(i)[2]);
				wr.write("\n");


			}
			b = food.run(dfs);

			wr.write("\n\nDFS result: \n");
			for(  i = 0 ;i < dfs.size() - 1;i++) {
				name = index.get(dfs.get(i)).toString();
				
				wr.write(name+"        " + b.get(i)[1] + "    " + b.get(i)[2]);
				wr.write("\n");
//				System.out.println(name);

			}

			

			
			wr.close();
			

		}
		catch(Exception e) {
			System.out.println(e)
;		}
		
		
		

	}
//	
	
	public static void main(String[] args) {
		
		
        
      output();


		
	
	

	}

}
