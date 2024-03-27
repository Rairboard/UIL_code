import java.util.*;
import java.io.*;

public class spanishquiz {
    public static void main(String[] args) throws Exception {
        new spanishquiz().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("spanishquiz.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();f.nextLine();
		Map<String,String> country = new HashMap<>(), capital = new HashMap<>();
		country.put("Mexico D.F.", "Mexico");
		country.put("Guatemala","Guatemala");
		country.put("Tegucigalpa","Honduras");
		country.put("San Salvador","El Salvador");
		country.put("Managua","Nicaragua");
		country.put("San Jose","Costa Rica");
		country.put("Panama","Panama");
		country.put("Caracas","Venezuela");
		country.put("Bogota","Colombia");
		country.put("Quito","Ecuador");
		country.put("Lima","Peru");
		country.put("La Paz","Bolivia");
		country.put("Asuncion","Paraguay");
		country.put("Santiago","Chile");
		country.put("Buenos Aires","Argentina");
		country.put("Montevideo","Uruguay");
		country.put("Brasilia","Brazil");
		for(String capitalCity : country.keySet()){
			capital.put(country.get(capitalCity),capitalCity);
		}
        while (times-- > 0) {
			String s = f.nextLine();
			String countryName, cityName;
			if(s.matches("What is the capital city of.*")){
				countryName = s.substring(s.lastIndexOf(" ")+1,s.indexOf("?"));
				System.out.println(capital.get(countryName) + " is the capital city of " + countryName + ".");
			} else{
				cityName = s.substring(0,s.indexOf("is")-1);
				System.out.println(cityName + " is the capital city of " + country.get(cityName) + ".");
			}
        }
        f.close();
    }
}
