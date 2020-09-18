package myFlight;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.Duration;


public class Main {
	public static void main(String[] args) {		

		//criando Geo
		Geo teste = new Geo(100 , 200);
		
		///////////////////////////////////////////////////////////
		GerenciadorAeroportos gerAirport = GerenciadorAeroportos.getInstance();
		System.out.println("\"-----> GERENCIADOR AEROPORTOS: <----- ");
		
		//Criando aeroportos
		Aeroporto air1 = new Aeroporto("00", "air1", teste);
		Aeroporto air2 = new Aeroporto("01", "air2", teste);
		Aeroporto air3 = new Aeroporto("02", "air3", teste);
		
		//Adicionando aeroportos no Gerenciador
		gerAirport.adicionar(air1);
		gerAirport.adicionar(air2);
		gerAirport.adicionar(air3);
		
		//Buscar aeroporto
		Aeroporto aux = gerAirport.buscar("01");
		if (aux != null)
			System.out.println("Encontrado: " + aux.toString() + "\n");
		else
			System.out.println("Não encontrado");
		
		//Listar:
		gerAirport.listar();
		
		///////////////////////////////////////////////////////////
		System.out.println("\n \n");		
		System.out.println("-----> GERENCIADOR AERONAVES: <-----");
		GerenciadorAeronaves gerAircraft = GerenciadorAeronaves.getInstance();
		
		//Criando aeronaves
		Aeronave craft1 = new Aeronave("AC01" , "Lorem ipsum dolor sit amet");
		Aeronave craft2 = new Aeronave("AC02" , "Consectetur adipiscing elit");
		Aeronave craft3 = new Aeronave("AC03" , "Sed do eiusmod tempor incididunt");
		
		//Adicionando aeronaves no Gerenciador
		gerAircraft.adicionar(craft1);
		gerAircraft.adicionar(craft2);
		gerAircraft.adicionar(craft3);
		
		gerAircraft.listar();
		///////////////////////////////////////////////////////////
		System.out.println("\n \n");		
		System.out.println("-----> GERENCIADOR COMPANHIA AEREA: <-----");
		GerenciadorCias gerEmpresas = GerenciadorCias.getInstance();
		
		CiaAerea cia1 = new CiaAerea("CIA01" , "Lorem");
		CiaAerea cia2 = new CiaAerea("CIA02" , "Ipsum");
		CiaAerea cia3 = new CiaAerea("CIA03" , "Dolor");
		
		gerEmpresas.adicionar(cia1);
		gerEmpresas.adicionar(cia2);
		gerEmpresas.adicionar(cia3);
		
		gerEmpresas.listar();
		///////////////////////////////////////////////////////////
		System.out.println("\n \n");        
		System.out.println("-----> GERENCIADOR ROTA: <-----");
		GerenciadorRotas gerRota = GerenciadorRotas.getInstance();
		
		Rota rota01 = new Rota(cia1, air1, air2, craft1);
		Rota rota02 = new Rota(cia2, air2, air1, craft2);
		Rota rota03 = new Rota(cia3, air1, air3, craft3);
		
		gerRota.adicionar(rota01);
		gerRota.adicionar(rota02);
		gerRota.adicionar(rota03);
		
		gerRota.listar();
		///////////////////////////////////////////////////////////
		System.out.println("\n \n");        
		System.out.println("-----> GERENCIADOR VOO: <-----");
		GerenciadorVoos gerVoo = GerenciadorVoos.getInstance();
		
		LocalDateTime datahora01 = LocalDateTime.of(2020, 8, 29, 17, 30);
		LocalDateTime datahora02 = LocalDateTime.of(2020, 9, 2, 15, 00);
		LocalDateTime datahora03 = LocalDateTime.of(2020, 9, 10, 10, 30);
		
		Duration duracao01 = Duration.ofMinutes(120);
		Duration duracao02 = Duration.ofMinutes(300);
		Duration duracao03 = Duration.ofMinutes(740);
		
		Voo voo01 = new Voo(rota01,datahora01,duracao01);
		Voo voo02 = new Voo(rota01,datahora02,duracao02);
		Voo voo03 = new Voo(rota01,datahora03,duracao03);
		
		gerVoo.adicionar(voo01);
		gerVoo.adicionar(voo02);
		gerVoo.adicionar(voo03);
		
		gerVoo.listar();
	}
}
