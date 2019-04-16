package Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class mcd {
	private static List<String> states = new ArrayList<String>();
	private static List<Double> lat = new ArrayList<Double>();
	private static List<Double> lon = new ArrayList<Double>();
	private static List<String[]> mcd = new ArrayList<String[]>();

	public static List<String[]>	InRange() {

		lat = getGeo.getLat();
		lon = getGeo.getLon();
		states = getGeo.getState();
		
		try {
			
		File f = new File("2XB3_A2_DataSets/mcdonalds.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		  
		String str = br.readLine();
		str = br.readLine();
		
		while(str !=  null) {
			str.replace("-", "");
			String[] temp = str.split(",");
			
			String s = temp[3].replace("\"", "");		
			double longg = Double.parseDouble(temp[0]);
			double latt = Double.parseDouble(temp[1]);
			int i  = 0;
			while(i < lat.size()) {
				double deltaLat = Math.abs(Math.abs(latt) - Math.abs(lat.get(i)));
				double deltaLong = Math.abs(Math.abs(longg) - Math.abs(lon.get(i)));
				if (s.compareTo(states.get(i)) == 0) {
					if (deltaLat < 0.5 && deltaLong < 0.5 ) {
						mcd.add(temp);

						break;
					}
				}
				i++;
			}
			str = br.readLine();
		}

		br.close();

		}
		catch(Exception e) {
			
		}
		
		return mcd;
	
	}
}



/**
For testing 

//			System.out.println(s);


//for(String w : mcd) {
//	System.out.println(w);
//
//}
//System.out.println(mcd.size());
*/