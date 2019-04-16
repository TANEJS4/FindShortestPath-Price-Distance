package Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class getGeo {
	private static List<String> stateName = new ArrayList<String>();
	private static List<Double> lat = new ArrayList<Double>();
	private static List<Double> lon = new ArrayList<Double>();
	private static List<String> cityName = new ArrayList<String>();

	public static double getLat(String city) {
		geo();
		for(int i = 0 ; i < cityName.size();i++) {
			if (cityName.get(i).toString().compareTo(city) == 0 ) {
				return lat.get(i);
			}
		}
		return -1;
	}
	public static double getLong(String city) {
		geo();
		for(int i = 0 ; i < cityName.size();i++) {
			if (cityName.get(i).toString().compareTo(city) == 0 ) {
				return lon.get(i);
			}
		}
		return -1;
	}
	public static List<Double> getLon() {
		geo();
		return lon;
	}
	public static List<Double> getLat() {
		geo();
		return lat;
	}
	
	public static List<String> getState() {
		geo();
		return stateName;
	}
	public static void geo() {
		try {
			File f = new File("2XB3_A2_DataSets/UScities.csv");
    		BufferedReader br = new BufferedReader(new FileReader(f));
			
    		  
            // put() method 
			String str = br.readLine();
			 str = br.readLine();
			 str = br.readLine();
//				System.out.println(mcd.size());

     		while(str != null) {
     			
    			String[] temp = str.split(",");
//    			System.out.println(temp[2]);

    			stateName.add(temp[2]);
    			cityName.add(temp[3]);

    			lat.add(Double.parseDouble(temp[4]));
    			lon.add(Double.parseDouble(temp[5]));

     			str = br.readLine();

    		}
//     		for(int i =0 ; i < lon.size();i++) {
//     			System.out.println("name: "+ cityName.get(i).toString() +" lat: "+ lat.get(i)+ " lon: "+ lon.get(i) );
//     		}
     		br.close();
		}
		catch ( Exception e) {
			System.out.println(e);
		}

	}
}
