package retoSofka.model;

public class HistorialDTO {
	
	private int id_user;
	private int numeroIntento;
	private int puntaje;
	
	

	public HistorialDTO() {
		
	}
	

	public HistorialDTO(int id_user, int numeroIntento, int puntaje) {
		super();
		this.id_user = id_user;
		this.numeroIntento = numeroIntento;
		this.puntaje = puntaje;
	}



	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getNumeroIntento() {
		return numeroIntento;
	}
	public void setNumeroIntento(int numeroIntento) {
		this.numeroIntento = numeroIntento;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	


	@Override
	public String toString() {
		return "HistorialDTO [id_user=" + id_user + ", numeroIntento=" + numeroIntento + ", puntaje=" + puntaje
				+  "]";
	}	
	
	
}
