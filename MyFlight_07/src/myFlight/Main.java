package myFlight;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.Duration;


public class Main {
	public static void main(String[] args) {
		
		
		Geo geo01 = new Geo(100 , 200);
		Geo geo02 = new Geo(200 , 300);
				
		int escolha;
		String codigo, nome;
		int contador = 1;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bem-vindo(a) ao MyFlight! Digite a ação desejada:\n1-Gerenciar Sistema\n2-Conferir dados");
		escolha = input.nextInt();
		
		switch(escolha) {
		
		case 1:
			
			System.out.println("Digite o que deseja adicionar\n1-Adicionar Aeronave\n2-Adicionar Aeroporto\n3-Adicionar Companhia Aerea"
					+ "\n4-Adicionar Rota\n5-Adicionar Voo\n0-Voltar");
			escolha = input.nextInt();
					
			
			if (escolha == 1) {
				GerenciadorAeronaves gerAircraft = GerenciadorAeronaves.getInstance();
				System.out.println("Você escolheu adicionar uma aeronave\n");
				
				System.out.println("Digite o código: ");
				codigo = input.next();
				
				System.out.println("Digite a descrição: ");
				String descricao = input.next();
				
				gerAircraft.adicionar(new Aeronave(codigo , descricao));
			}
			
			if (escolha == 2) {
				
				GerenciadorAeroportos gerAirport = GerenciadorAeroportos.getInstance();
								
				
				System.out.println("Você escolheu adicionar um aeroporto\n");
				
				System.out.println("Digite o código: ");
				codigo = input.next();
				
				System.out.println("Digite o nome: ");
				nome = input.next();
				
				System.out.println("Escolha a latitude e longitude:\n1 - 100, 200\n2 - 200,300 ");
				int aux = input.nextInt();
				
				if (aux == 1) {
					
					gerAirport.adicionar(new Aeroporto(codigo, nome, geo01));
				}
				
				if (aux == 2) {
					
					gerAirport.adicionar(new Aeroporto(codigo, nome, geo02));
				}
				
				if (escolha == 3) {
					
					GerenciadorCias gerCia = GerenciadorCias.getInstance();
					
					System.out.println("Você escolheu adicionar uma Companhia Aerea\n");
					
					System.out.println("Digite o código: ");
					codigo = input.next();
					
					System.out.println("Digite o nome: ");
					nome = input.next();
					
					gerCia.adicionar(new CiaAerea(codigo, nome));
				}
				
				if (escolha == 4) {
					
					GerenciadorRotas gerRota = GerenciadorRotas.getInstance();
					GerenciadorCias gerCia = GerenciadorCias.getInstance();
					GerenciadorAeroportos gerAero = GerenciadorAeroportos.getInstance();
					GerenciadorAeronaves gerAeronave = GerenciadorAeronaves.getInstance();
					
					System.out.println("Você escolheu adicionar uma Rota\n");
					
					System.out.println("Digite o código da Companhia Aerea: ");
					String cia = input.next();
					
					CiaAerea findCia = gerCia.buscar(cia);
					
					System.out.println("Digite a Origem: ");
					String origem = input.next();
					
					Aeroporto findOrigem = gerAero.buscar(origem);
					
					System.out.println("Digite o Destino: ");
					String destino = input.next();
					
					Aeroporto findDest = gerAero.buscar(destino);
														
					System.out.println("Digite o código da aeronave: ");
					String aeronave = input.next();
					
					Aeronave findAeronave = gerAeronave.buscar(aeronave);
					
					gerRota.adicionar(new Rota(findCia, findOrigem, findDest, findAeronave));
				}
				
				if (escolha == 5) {
					
					GerenciadorVoos gerVoos = GerenciadorVoos.getInstance();
					GerenciadorAeroportos gerAero = GerenciadorAeroportos.getInstance();
					GerenciadorAeronaves gerAeronave = GerenciadorAeronaves.getInstance();
					GerenciadorRotas gerRota = GerenciadorRotas.getInstance();
				
					System.out.println("Você escolheu adicionar um Voo\n");
					
					System.out.println("Digite a Origem: ");
					String origem = input.next();
					
					Aeroporto findOrigem = gerAero.buscar(origem);
					
					System.out.println("Digite o Destino: ");
					String destino = input.next();
					
					Aeroporto findDest = gerAero.buscar(destino);
					
					System.out.println("Digite o codigo da Aeronave: ");
					String aeronave = input.next();
					
					Aeronave findAeronave = gerAeronave.buscar(aeronave);
					
					Rota findRota = gerRota.buscar(findDest, findOrigem, findAeronave);
					
					System.out.println("Digite o ano: ");
					int ano = input.nextInt();
					
					System.out.println("Digite o mês: ");
					int mes = input.nextInt();
					
					System.out.println("Digite o dia: ");
					int dia = input.nextInt();
					
					System.out.println("Digite as horas: ");
					int horas = input.nextInt();
					
					System.out.println("Digite os minutos: ");
					int minutos = input.nextInt();
					
					LocalDateTime datahora = LocalDateTime.of(ano, mes, dia, horas, minutos);
					
					System.out.println("Digite a Duração: ");
					int tempo = input.nextInt();
					Duration duracao = Duration.ofMinutes(tempo);
					
					gerVoos.adicionar(new Voo(findRota, datahora, duracao));
					
				}
				
			}
			break;
			
			
		case 2:		
						
			System.out.println("Digite o que deseja adicionar\n1-Conferir Aeronaves\n2-Conferir Aeroportos\n3-Conferir Companhias Aereas"
					+ "\n4-Conferir Rotas\n5-Conferir Voos\n0-Voltar");
			escolha = input.nextInt();
			
			if (escolha == 1) 
			{
				GerenciadorAeronaves gerAircraft = GerenciadorAeronaves.getInstance();				
				System.out.println("Você escolheu conferir Aeronaves:\n");				
				gerAircraft.listar();
			}
			if (escolha == 2) 
			{
				GerenciadorAeroportos gerAirport = GerenciadorAeroportos.getInstance();				
				System.out.println("Você escolheu conferir Aeroportos:\n");				
				gerAirport.listar();
			}
			if (escolha == 3) 
			{
				GerenciadorCias gerCia = GerenciadorCias.getInstance();
				System.out.println("Você escolheu conferir Companhias Aereas:\n");				
				gerCia.listar();
			}
			if (escolha == 4) 
			{
				GerenciadorRotas gerRota = GerenciadorRotas.getInstance();				
				System.out.println("Você escolheu conferir Rotas:\n");				
				gerRota.listar();
			}
			if (escolha == 5) 
			{
				GerenciadorVoos gerVoos = GerenciadorVoos.getInstance();		
				System.out.println("Você escolheu conferir Voos:\n");				
				gerVoos.listar();
			}
			break;		
		}
		
/*
		
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
		
		gerVoo.listar();*/
	}
}
