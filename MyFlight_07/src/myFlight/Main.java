package myFlight;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.Duration;


public class Main {
	public static void main(String[] args) {
		
		Geo teste = new Geo(100,200);
		
		CiaAerea cia1 = new CiaAerea("CIA01" , "Lorem");
		CiaAerea cia2 = new CiaAerea("CIA02" , "Ipsum");
		CiaAerea cia3 = new CiaAerea("CIA03" , "Dolor");
		
		Aeroporto air1 = new Aeroporto("00", "air1", teste);
		Aeroporto air2 = new Aeroporto("01", "air2", teste);
		
		Aeronave craft1 = new Aeronave("AC01" , "Lorem ipsum dolor sit amet");
		Aeronave craft2 = new Aeronave("AC02" , "Consectetur adipiscing elit"); 		
		
		LocalDateTime datahora = LocalDateTime.of(2020, 02, 8, 15, 30);
		
		Rota rota01 = new Rota(cia1, air1, air2, craft1); // ROTA
		Rota rota02 = new Rota(cia2, air2, air1, craft2);
		Rota rota03 = new Rota(cia3, air1, air2, craft2);
		LocalDateTime datahora01 = LocalDateTime.of(2020, 8, 12, 12, 00); // DATA
		Duration duracao01 = Duration.ofMinutes(120); //DURAÇÃO
		VooEscalas vooEscala01 = new VooEscalas(datahora);
		VooDireto vooDireto01 = new VooDireto(rota01, datahora01, duracao01);
		
		vooEscala01.adicionaRota(rota01);
		vooEscala01.adicionaRota(rota02);
		vooEscala01.adicionaRota(rota03);
		
		Geo testDist = new Geo(101.0, 220.0);
		double distancia = testDist.distancia(testDist);
		System.out.println("---------DISTANCIA GEO:-----------\n" + distancia);
		System.out.println("---------VOO ESCALAS:-----------\n" + vooEscala01);
		vooEscala01.listar();
		System.out.println("---------VOO DIRETO:-----------\n" + vooDireto01);
		
		/*
		Geo geo01 = new Geo(100 , 200);
		Geo geo02 = new Geo(200 , 300);
		
		int escolha;
		String codigo, nome;
		
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
		}*/
	}
}
