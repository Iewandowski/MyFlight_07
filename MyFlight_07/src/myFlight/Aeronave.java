package myFlight;

public class Aeronave implements Imprimivel, Contavel, Comparable<Aeronave> {
	
	private String codigo;
	private String descricao;
	public static int totalObjetos = 0;
	
	public Aeronave(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		totalObjetos++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static int getTotalObjetos() {
		return totalObjetos;
	}	
	
	public void contar() {
		System.out.println(totalObjetos);
	}
	
	  public void imprimir() {
	       System.out.println(codigo + " - " + descricao);
	    }
	
	//Comparação
	@Override
	public int compareTo(Aeronave outra) {
		return descricao.compareTo(outra.descricao);
	}
	
	public String toString() {
		return "Codigo: " + codigo + " Descrição: " + descricao;
	}
}