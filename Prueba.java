
public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cafeteria cafe;
		
		cafe = new Cafeteria ( "Muguet",  "5566124356",  "rio Hondo 123");
		
		
		cafe.altaMesa("alejandro", 4, "normal");
		cafe.mesaAltaCafe("alejandro", "CAPUCHINO", true,'S', false, 'F');
		cafe.mesaAltaCafe("alejandro", "AMERICANO", true,'L', true, 'F');
		cafe.altaMesa("mauricio", 6, "fumadores");
		cafe.altaMesa("maria", 2, "fumadores");
		cafe.mesaAltaCafe("maria", "capuchino", true, 'M', false, 'F');
		cafe.mesaAltaCafe("alejandro", "latte", false, 'S', false, 'C');
		System.out.println(cafe.toString());
		System.out.println(cafe.busca("maria"));
		System.out.println(cafe.busca("mauricio"));
		cafe.baja("mauricio", "fumadores");
		cafe.mesaBajaCafe("maria", 3);
		
		cafe.cambioMesa("alejandro", "normal", 1, 1);
		System.out.println(" \n-------------este es el toString"+cafe.toString());
		//System.out.println(cafe.busca("alejandro"));
		//cafe.mesaBajaCafe("alejandro", 1);
		//cafe.busca("alejandro");
		//System.out.println(cafe.mesaCuantosCafesMasCaros("alejandro", 200));
		//System.out.println(cafe.cafeMasCaro("alejandro"));
		//cafe.mesaBajaCafe("alejandro", 1);
		//System.out.println(cafe.busca("alejandro"));
		
		
		//System.out.println(cafe.busca("mauricio"));
		//System.out.println(cafe.toString());
		//System.out.println(cafe.busca("alejandro"));
		//cafe.mesaAltaCafe("alejandro", "LATTE", true, 'M', false, 'C');           
		//cafe.mesaBajaCafe("alejandro", 3);
		//cafe.mesaAltaCafe("mauricio", "AMERICANO", true, 'L', true, 'F');
		//System.out.println(cafe.toString());
		
		//cafe.cambioMesa("alejandro", "normal", 1, 3);
		
		//cafe.altaMesa("Raul", 2, "normal");
		
		//System.out.println(cafe.busca("alejandro"));
		//System.out.println(cafe.busca("mauricio"));
		//System.out.println(cafe.toString());
		//System.out.println(cafe.busca("Raul"));
		//System.out.println(cafe.busca("alejandro"));
		
	}

}
