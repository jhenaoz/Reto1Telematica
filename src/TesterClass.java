

import java.util.List;

import Entity.Imagenes;
import Service.ServiceImages;

public class TesterClass {

	public static void main(String[] args) {
		ServiceImages service = new ServiceImages();
		List<Imagenes> res= service.retriveImages();
		for (Imagenes img : res) {
			System.out.println(img.getName());
		}
	}
}
