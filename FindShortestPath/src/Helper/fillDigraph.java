package Helper;
import Search.*;
import java.util.List;


public class fillDigraph {

	public static Digraph fill( int v) {
		
	     
        List<String> uniqueRef = lines.index();

        List<String> src = lines.getSrc();
        List<String> des = lines.getDes();
        
 
        Digraph g = new Digraph(uniqueRef.size());
        
   
        for(int i = 0; i < src.size();i++) {
        	int srcIn = uniqueRef.indexOf(src.get(i));

        	int desIn = uniqueRef.indexOf(des.get(i));
        	g.addEdge(srcIn, desIn); 

        }

        return g;
	}
}
