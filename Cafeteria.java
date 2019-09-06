import java.util.ArrayList;

public class Cafeteria implements Comparable<Cafeteria> {
	
	private String nombre;
	private String telefono;
	private String direccion;
	private Mesa [][] mesa;
	private String [] zona= {"normal","fumadores"};
	private int [] cant;
	private  final int RENG=2;
	private  final int COL=4;
	
	public Cafeteria () {
		mesa=new Mesa[RENG][COL];
		cant = new int [RENG];
	}

	public Cafeteria(String nombre, String numero, String direccion) {
		this();
		this.nombre = nombre;
		this.telefono = numero;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNumero() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public boolean altaMesa(String nombreReserv, int personas, String fumadores) {
		boolean resp =false;
		int i=0;
		int j=0;
		
		
			while(i<RENG && !zona[i].equals(fumadores)) {
				i++;
			}
			if(i<RENG) {
				if(cant[i]<COL) {
					while(mesa[i][j]!=null) {
						j++;
					}
					Mesa m= new Mesa(nombreReserv,  personas,  fumadores);
					
					mesa[i][j]=m;
					resp=true;
					cant[i]++;
				
				}
			}
		
		return resp;
	}
	
	public Mesa busca(String nombreReserv) {
		Mesa buscando = new Mesa (nombreReserv);
		Mesa m =null;
		boolean encontre = false;
		
		int i=0;
		int j =0;
		
		
		while (i<RENG && !encontre) {
			
			j=0;
			
			while(j<COL && !encontre ) {
				//System.out.println(mesa[i][j]);
				if(mesa[i][j] != null && mesa[i][j].equals(buscando)) {
					encontre =true;
					m=mesa[i][j];
				}
				j++;
			}
			i++;
		}
		return m;
		
	}
	
	public Mesa baja (String nombreReserv,String fumadores  ) {
		int i=0;
		Mesa m = null;
		
		
		while(i<RENG && !zona[i].equals(fumadores)) {
			i++;
		}
			if(i<RENG) {
				//System.out.println("ntre renglon");
				int j=0;
				while (j<cant[i]&& !mesa[i][j].equals(new Mesa (nombreReserv))) {
					//System.out.println(" Entro al while ");
					j++;
					//System.out.println(" esto es J :" +j);
				}
				//System.out.println(" esto es cant "+cant[i]);
					if(j<cant[i]) {
						//System.out.println("foinal ");
						m=mesa[i][j];
						mesa[i][j]=null;
						cant[i]--;
						/*m=mesa[i][j];
						mesa[i][j]=null;
						j++;
						while (mesa[i][j]!=null) {
							mesa[i][j-1]=mesa[i][j];
							j++;
						
						}
						mesa[i][j-1]=null;
						cant[i]--;*/
					
					}
					
					
			}
		
			return m;
	}
	
	public boolean cambioMesa(String nombreReserv,String fumadores, int RENG, int COL) {
		boolean resp=false;
		Mesa m;
		m=busca(nombreReserv); //
		
		if(m!=null) {
			if(mesa[RENG][COL]==null) {
				m=baja(nombreReserv,fumadores);
				mesa[RENG][COL]=m;
				cant[RENG]++;
				resp=true;
			}
			
		}
		
		return resp;
		
	}
	
	public boolean mesaAltaCafe(String nombreReserv,String nombre, boolean decaf, char tamaño,  boolean crema, char temp ) {
		boolean resp =false;
		Mesa m=null;
		m=busca(nombreReserv);
		if(m!=null) {
			m.altaCafe(nombre, decaf, tamaño, crema, temp);
			
		}
		
		return resp;
	}
	
	public boolean mesaBajaCafe(String nombreReserv,int clave ) {
		boolean resp =false;
		Mesa m=null;
		m=busca(nombreReserv);
		
		if(m!=null) {
			m.bajaCafe(clave);
			
			resp = true;
		}
		return resp;
	}
	
	public int mesaCuantosCafesMasCaros(String nombreReserv, double precio) {
		int resp = -123;
		Mesa m;
		m=busca(nombreReserv);
		resp=m.cuantosMasCaros(precio);
		
		return resp;
	}
	
	public Cafe cafeMasCaro(String nombreReserv) {
		Cafe resp= null;
		Mesa m;
		
		m=busca(nombreReserv);
		resp=m.cafeMasCaro();
		
		return resp;
	}
	
	public int mesaCuantosCafesMasBaratos(String nombreReserv, double precio) {
		int resp = -123;
		Mesa m;
		
		m=busca(nombreReserv);
		resp=m.cuantosMasBaratos(precio);
		
		return resp;
	}
	public Cafe cafeMasBarato(String nombreReserv) {
		Cafe resp= null;
		Mesa m;
		
		m=busca(nombreReserv);
		resp=m.cafeMasBarato();
		
		return resp;
	}
	
	/*public String mesaConsultaTamaños(String nombreReserv,char tamaño) {
		ArrayList<String> resp=new ArrayList<String>();
		Mesa m;
		m=busca(nombreReserv);
		resp=m.consulta(tamaño);
		if(resp == null) {
			resp =null;
		}
		
		
		return resp.toString();
	}*/
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Cafeteria other = (Cafeteria) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public int compareTo(Cafeteria otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nEl nombre del restaurente es: " + nombre);
		cad.append("\nEl telefono es : " + telefono);
		cad.append("\nLa direccion es : " + direccion);
		cad.append("\n");
		for (int i=0;i<RENG;i++) {
			cad.append("\n");
			cad.append("\n"+zona[i]);
			cad.append("\t"+cant[i]);
			for(int j=0;j<COL;j++) {
				cad.append("          \t" + mesa[i][j]);
				}
			}
		
		
		return cad.toString();
	}
	
	
	
}

