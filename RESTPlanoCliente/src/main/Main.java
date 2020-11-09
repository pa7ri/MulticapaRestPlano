package main;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

		public static void main(String[] args)  {
			
						  
			try {
				
					URL url = new URL("http://localhost:8080/RESTplano/saluda?nombre=Charlton&apellido=Heston");
					
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					
					con.setRequestMethod("GET");
				  
					InputStream in = con.getInputStream();
					byte[] b = new byte[1024];  
					int result = in.read(b);
					while (result != -1) {
											System.out.write(b,0,result);
											result =in.read(b);
										  }
					in.close();
					con.disconnect();
				  
		} catch (Exception e) {e.printStackTrace();}

	}

}
