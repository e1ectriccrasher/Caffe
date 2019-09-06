import java.util.ArrayList;

public class Mesa implements Comparable <Mesa> {
	private String nombreReserv;
	private int personas;
	private String fumadores;
	private Cafe [] cafe;
	private static final int MAX =10;
	private int totCafes;
	
	public Mesa() {
		cafe = new Cafe[MAX];
	}

	public Mesa(String nombreReserv, int personas, String fumadores) {
		this();
		this.nombreReserv = nombreReserv;
		this.personas = personas;
		this.fumadores = fumadores;
	}
	
	public Mesa(String nombreReserv,  int personas, String fumadores, int max_mesas) {
		cafe = new Cafe[max_mesas];
		this.nombreReserv = nombreReserv;
		this.personas = personas;
		this.fumadores = fumadores;
	}

	public Mesa(String nombreReserv) {
		super();
		this.nombreReserv = nombreReserv;
	}

	public String isFumadores() {
		return fumadores;
	}

	public void setFumadores(String fumadores) {
		this.fumadores = fumadores;
	}

	public String getNombreReserv() {
		return nombreReserv;
	}


	public int getPersonas() {
		return personas;
	}

	public String getUnCafe(Integer clave) {
		String resp = "no es valido";
		Cafe c;
		int pos;
		
		c=new Cafe(clave);
		pos=0;
		while(pos<totCafes && cafe[pos].equals(c));
		pos++;	
		if(pos!=totCafes)
			resp=cafe[pos].toString();
		return resp;
		 
	}

	public int getTotCafes() {
		return totCafes;
	}
	
	public boolean altaCafe(String nombre, boolean decaf, char tamaño,  boolean crema, char temp) {
		boolean resp =false ;
		Cafe c;
		
		c= new Cafe( nombre, decaf,  tamaño, crema,  temp);
		if(totCafes<cafe.length) {
			cafe[totCafes]=c;
			totCafes++;
			resp=true;
		}
		
		return resp;
	}
	
	public boolean bajaCafe(Integer clave) {
		boolean resp = false;
		int n=0;
		
		n=MnjArrGen.eliminaOrdenado((Comparable [])cafe, totCafes, (Comparable) new Cafe(clave));
		
		//System.out.println(" este es n  :" +n);
		if(n>=0) {
			//System.out.println(" si encontro el cafe");
			resp = true;
			totCafes=n;
			
		}
			
		
		return resp;
	}
	
	/*public Cafe datosCafe(Integer clave) {
		Cafe c = null;
		int pos =0;
		
		pos = MnjArrGen.busquedaSecuencialOrdenada((Comparable [])cafe, totCafes, (Comparable)clave);
		c = cafe[pos];
		
		return c;
		
	}*/
	
	
	
	public Cafe cafeMasCaro() {
		Cafe c, mayor;
		c= cafe[0];
		mayor =null;
		
		
		for(int i=1;i<totCafes;i++) {
			mayor= cafe[i];
			if(c.calculaCostoCafe()>mayor.calculaCostoCafe()) 
				mayor=c;		
		}
		
		
		return mayor;
	}
	
	public int cuantosMasCaros(double precio) {
		int cont=0;
		Cafe otro;
		
		for(int i=0;i<totCafes;i++) {
			otro=cafe[i];
			if(precio<otro.calculaCostoCafe())
				cont++;
		}
		return cont;
	}
	
	public Cafe cafeMasBarato() {
		Cafe c, menor;
		c= cafe[0];
		menor =null;
		
		
		for(int i=1;i<totCafes;i++) {
			menor= cafe[i];
			if(c.calculaCostoCafe()<menor.calculaCostoCafe()) 
				menor=c;		
		}
		return menor;
	}
	
	public int cuantosMasBaratos(double precio) {
		int cont=0;
		Cafe otro;
		
		
		for(int i=0;i<totCafes;i++) {
			otro=cafe[i];
			if(precio>otro.calculaCostoCafe())
				cont++;
		}
		
		return cont;
	}
	
	/*public  ArrayList<String> consulta (char tamaño) {
		ArrayList<String> resp=new ArrayList<String>();
		
		for(int i=0;i<totCafes;i++) {
			
			if(cafe[i].getTamaño()==tamaño)
				resp.add(cafe[i].toString());
			
				if(cafe[i].getTamaño()==tamaño)
					resp.add(cafe[i].toString());
				
					if(cafe[i].getTamaño()==tamaño)
						resp.add(cafe[i].toString());
		}
		
			if(resp.isEmpty()) {
				resp=null;
			}
			
			
			return resp;
	}*/
	
	public double calculaCuenta() {
		double resp =0;
		double suma=0;
		for(int i=0;i<totCafes;i++) {
			suma =cafe[i].calculaCostoCafe();
			resp+=suma;
			
		}
		
		return resp;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreReserv == null) ? 0 : nombreReserv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (nombreReserv == null) {
			if (other.nombreReserv != null)
				return false;
		} else if (!nombreReserv.equals(other.nombreReserv))
			return false;
		return true;
	}
	
	
	
	public int compareTo(Mesa otro) {
		return nombreReserv.compareTo(otro.nombreReserv); 	
		
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		cad.append("reservación :" + nombreReserv);
		//cad.append("\nEl numero de personas es : " + personas);
		//cad.append("\nLa mesa es : " + fumadores);
		//cad.append("\nEl total de la cuenta es : " + calculaCuenta());
		//cad.append("\nDatos cafe(s): ");
		//cad.append("\n");
		//for(int i=0; i<totCafes;i++) {
			//cad.append("\n");
			//cad.append(cafe[i].toString());
			//cad.append("\n");
			
		//}
		
		
		return cad.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
