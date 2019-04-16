package Helper;
import Search.*;
import java.util.List;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


public class food {

	private static List<String[]> result = new ArrayList<String[]>();
	private static List<String[]> mac = new ArrayList<String[]>();
	private static List<String[]> MENU = new ArrayList<String[]>();
	
//	private static List<Integer> route = new ArrayList<Integer>();

	private static List<String> index = new ArrayList<String>();

	public static List<String[]> menu(){
		List<String[]> menu = new ArrayList<String[]>();

		try {
			
			File f = new File("2XB3_A2_DataSets/menu.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			  
			String str = br.readLine();
			str = br.readLine();
			
			while(str !=  null) {
//				str.replace("$" , "");
				String[] temp = str.split(",");
				
				menu.add(temp);
				str = br.readLine();
			}

			br.close();

			}
			catch(Exception e) {
				
			}
		Collections.sort(menu, (a, b) -> { return a[2].toString().compareTo(b[2].toString());}  );

//		for(int i = 0; i <menu.size();i++) {
//		System.out.println(menu.get(i)[0].toString());
//	}
		return menu;
	
	}
	


	

	
	public static List<String[]> run(List<Integer> route) {

		
		mac = mcd.InRange();


		MENU = menu();
		index = lines.index();

		int iteration = 0;

			for(int j = 0 ; j < route.size();j++) {
	
		
					for(int i =0 ;i < MENU.size(); i++) {
						if ( MENU.get(i)[0].toString().compareTo("McDonald’s") == 0) {
							
							if(iteration%2 ==0) {
								result.add(MENU.get(0));
								break;

							}
							else {
								result.add(MENU.get(1));
								break;


							}
						}
						else if (MENU.get(i)[0].toString().compareTo("Wendy’s") == 0){
							if(iteration%2 ==0) {
								result.add(MENU.get(0));
								break;

							}
							else {
								result.add(MENU.get(1));
								break;

							}
							

		
						} 
						else if (MENU.get(i)[0].toString().compareTo("Burger King") == 0){
							
							if(iteration%2 ==0) {
								result.add(MENU.get(0));
								break;

							}
							else {
								result.add(MENU.get(1));
								break;

							}

						}
					}
					iteration++;
		
			}
			
		

		return result;
	}

	
	public static void main(String[] arg) {

	}

	
}
