package myFlight;

public class CiaAerea implements Comparable<CiaAerea>{
	
	private String codigo;
	private String nome;
	public static int totalCias = 0;
	
	public CiaAerea(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		totalCias++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	 public static int getTotalCias() {
	        return totalCias;
	    }
	
	 public int compareTo(CiaAerea outra)
	 {
	     return nome.compareTo(outra.nome);
	 }
	 
	public String toString() {
		return "Codigo: " + codigo + " Nome: " + nome;
	}

}
