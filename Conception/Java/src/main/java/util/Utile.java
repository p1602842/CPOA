package util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

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

	public static Node chargerFxml(String nom){

		try {
			Node root;
			URL fxmlUrl = Utile.recupererFichier("/Interface/Content/" + nom + ".fxml").toURI().toURL();
			FXMLLoader chargeurFxml = new FXMLLoader(fxmlUrl);
			root = chargeurFxml.load();
			return(root);
		} catch (Exception e) {
			e.printStackTrace();
			return(null);
		}
	}
}
