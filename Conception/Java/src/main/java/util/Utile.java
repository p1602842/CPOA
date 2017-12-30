package util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Utile {

	public static File recupererFichier(String path){

		URL url = Utile.class.getProtectionDomain().getCodeSource().getLocation();
		File jar = null;
		try {
			jar = new File(url.toURI());
		} catch (Exception e){
			e.printStackTrace();
		}
		return(new File(jar.getParent(), "classes/" + path));
	}

	public static InputStream recupererStream(String path){

		return(Utile.class.getResourceAsStream(path));
	}
}
