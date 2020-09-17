package myFlight;

import java.util.ArrayList;

public class GerenciadorCias {	
private ArrayList<CiaAerea> empresas;
	
private static GerenciadorCias instance;

private GerenciadorCias() {
	empresas = new ArrayList<>();
}

public static GerenciadorCias getInstance() {
	if (instance == null) {
		instance = new GerenciadorCias();
	}
	return instance;
}

public void adicionar(CiaAerea UmaEmpresa) { //adicionar empresa
	empresas.add(UmaEmpresa);
}

public CiaAerea buscar(String umCodigo) { //buscar por código
	for (CiaAerea empresa : empresas) {
		if(empresa.getCodigo() == umCodigo)
			return empresa;
	}
	return null;
}

public void listar() { //listar empresas
	System.out.println("Cadastro de Aeronaves: ");
	for (CiaAerea empresa: empresas) {
		System.out.println(empresa);
	}
}

}
