package myFlight;
import java.time.LocalDateTime;
import java.time.Duration;
public abstract class Voo {
public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora01;
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO;
	}
	
	public Voo(LocalDateTime datahora) {
		this.datahora = datahora;
		this.status = Status.CONFIRMADO;
	}
	
	public Voo(Rota rota, Duration duracao) {
		datahora01 = LocalDateTime.of(2020, 8, 12, 12, 00);
		this.rota = rota;
		datahora = datahora01;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO;
	}
	
	public Voo(LocalDateTime datahora, Duration duracao) {
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; 
	}	
	
	public abstract Rota getRota();
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public abstract Duration getDuracao();
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}
	
	public String toString() {
		return "-> Data e Hora: " + datahora + "\n-> Status: " + status;
	}
}
