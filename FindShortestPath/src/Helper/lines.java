package Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class lines {
	private static List<String> src = new ArrayList<String>();
	private static List<String> des = new ArrayList<String>();
	private static List<String> both = new ArrayList<String>();
	private static List<String> unique = new ArrayList<String>();


	public static void read() {

		try {
			File f = new File("2XB3_A2_DataSets/connectedCities.txt");
    		BufferedReader br = new BufferedReader(new FileReader(f));
			
    		  
            // put() method 
			String str = br.readLine();
			
     		while(str != null) {
     			
    			String[] temp = str.split(", ");

    			src.add(temp[0]) ;
    			des.add(temp[1]) ;

     			str = br.readLine();


    		}
     		br.close();
		}
		catch ( Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static List<String> getSrc() {
		read();
		return src;
	}
	
	public static List<String>  getDes() {
		read();
		return des;
	}

	
	public static List<String> index() {
		read();

		for(int i = 0 ; i <src.size();i++) {
			both.add(src.get(i));
			both.add(des.get(i));
		}

		unique.add(both.get(0));
		for(String element: both) {
			if(!unique.contains(element)) {
				unique.add(element);
				}
		}
	    Collections.sort(unique);         
//		for(int i = 0; i <unique.size();i++) {
//		System.out.println(unique.get(i));
//	}
		return unique;
	}
	
	public static void main(String[] args) {
//		read();
//		List<String> a=index();
//		System.out.println(a.get(3));
//		index();
	}
}
 
