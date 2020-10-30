package myFlight;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
	private ArrayList<Rota> rota;
	
	private static GerenciadorRotas instance;

	private GerenciadorRotas() {
		rota = new ArrayList<>();
	}

	public static GerenciadorRotas getInstance() {
		if (instance == null) {
			instance = new GerenciadorRotas();
		}
		return instance;
	}
	
	public void adicionar(Rota umaRota) { //adicionar vôo
		rota.add(umaRota);
	}

	public Rota buscar(Aeroporto destino, Aeroporto origem, Aeronave aeronave) { //buscar por meio de DESTINO, ORIGEM e AERONAVE
		for (Rota route : rota) {
			if (route.getDestino() == destino && route.getOrigem() == origem && route.getAeronave() == aeronave)
				return route;
		}
		return null;
	}
	public void listar() { //listar vôos
		System.out.println("Cadastro de Aeronaves: ");
		for (Rota route: rota) {
			System.out.println(route);
		}		
	}
	
	public void ordenaDescricao() {
        Collections.sort(rota);
    }
}
