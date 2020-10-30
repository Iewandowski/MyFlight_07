package myFlight;

import java.util.ArrayList;
import java.util.Collections;


public class GerenciadorAeronaves {
	private ArrayList<Aeronave> aeronave;	
	private static GerenciadorAeronaves instance;
	
	private GerenciadorAeronaves() {
		aeronave = new ArrayList<>();
	}
	
	public static GerenciadorAeronaves getInstance() {
		if (instance == null) {
			instance = new GerenciadorAeronaves();
		}
		return instance;
	}
	
	public void adicionar(Aeronave UmAeronave) { //adicionar aeronave
		aeronave.add(UmAeronave);
	}
	
	public Aeronave buscar(String umCodigo) { //buscar por código
		for (Aeronave aircraft : aeronave) {
			if(aircraft.getCodigo() == umCodigo)
				return aircraft;
		}
		return null;
	}
	
	public void listar() { //listar aeronaves
		System.out.println("Cadastro de Aeronaves: ");
		for (Aeronave aircraft: aeronave) {
			System.out.println(aircraft);
		}
	}
	
	public void ordenaDescricao() {
        Collections.sort(aeronave);
    }
}
