package myFlight;

public class Rota implements Comparable<Rota>{
	
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;
	
	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
		this.cia = cia;
		this.origem = origem;
		this.destino = destino;
		this.aeronave = aeronave;		
	}	
	
	public CiaAerea getCia() {
		return cia;
	}
	
	public Aeroporto getDestino() {
		return destino;
	}
	
	public Aeroporto getOrigem() {
		return origem;
	}
	
	public Aeronave getAeronave() {
		return aeronave;
	}                                                                                                                  
	
	//COMPARAÇÃO
	@Override
	public int compareTo(Rota outra) {
		return cia.compareTo(outra.cia);
	}	
	
	public String toString() {
		return "Companhia: " + cia + " Origem: " + origem + " Destino: " + destino + "Aeronave: " + aeronave;
	}

}
