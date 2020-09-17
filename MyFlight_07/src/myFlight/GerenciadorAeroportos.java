package myFlight;

import java.util.ArrayList;

public class GerenciadorAeroportos {
	
	private ArrayList<Aeroporto> aeroporto;
	
	private static GerenciadorAeroportos instance;
	
	private GerenciadorAeroportos() {
		aeroporto = new ArrayList<>();
	}
	
	public static GerenciadorAeroportos getInstance() {
		if (instance == null) {
			instance = new GerenciadorAeroportos();
		}
		return instance;
	}
	
	public void adicionar(Aeroporto Umaeroporto) { //adicionar aeroporto
		aeroporto.add(Umaeroporto);
	}
	
	public Aeroporto buscar(String umCodigo) { //buscar por código
		for (Aeroporto airport : aeroporto) {
			if(airport.getCodigo() == umCodigo)
				return airport;
		}
		return null;
	}
	
	public void listar() { //listar aeroportos
		System.out.println("Cadastro de Aeroportos: ");
		for (Aeroporto airport: aeroporto) {
			System.out.println(airport);
		}
	}	
}
