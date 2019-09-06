
public class Cafe implements Comparable<Cafe> {

	private String nombre;
	private boolean decaf;
	private char tamaño ;
	private boolean crema;
	private char temp;
	private Integer clave;
	private static Integer generador =1;
	
	
	

	public Cafe(String nombre, boolean decaf, char tamaño,  boolean crema, char temp) {
		this.clave=generador;
		this.nombre = nombre;
		this.decaf = decaf;
		this.tamaño = tamaño;
		this.crema = crema;
		this.temp = temp;
		generador+=1;
	}

	

	public Cafe(Integer clave) {
		super();
		this.clave = clave;
	}



	public boolean isDecaf() {
		return decaf;
	}


	public void setDecaf(boolean decaf) {
		this.decaf = decaf;
	}


	public char getTamaño() {
		return tamaño;
	}


	public void setTamaño(char tamaño) {
		this.tamaño = tamaño;
	}


	public boolean isCrema() {
		return crema;
	}


	public void setCrema(boolean crema) {
		this.crema = crema;
	}


	public String getNombre() {
		return nombre;
	}





	public char getTemp() {
		return temp;
	}
	
	public double calculaCostoCafe () {
		double base=0;
		switch (tamaño) {
		case('S'):
			base=70;
		break;
		case('M'):
			base=150;
		break;
		case('L'):
			base=270;
		break;
		}
		if(nombre.equals("CAPUCHINO"))
			base+=50;
		else
			if(nombre.equals("AMERICANO"))
				base+=20;
			else
				if(nombre.equals("LATTE"))
					base+=70;
		if(crema=true)
			base+=10;
		return base;
		
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
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
		Cafe other = (Cafe) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}



	public int compareTo(Cafe otro) {

		return this.clave.compareTo(otro.clave);
	}
	
	
	public String toString () {
		StringBuilder cad = new StringBuilder();
		cad.append(" Cafe : " +nombre);
		cad.append("\nClave del producto : " + clave);
		cad.append("\n El tamaño es : " + tamaño);
		cad.append("\n Descafeinado ;" + decaf);
		cad.append("\n Temperatura " + temp );
		cad.append(" \n Crema : " + crema);
		cad.append("\nEl precio del cafe es : " + calculaCostoCafe());
		
		
		return cad.toString();
	}
	
	
	
	
	

}
