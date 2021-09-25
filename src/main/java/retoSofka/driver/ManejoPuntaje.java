package retoSofka.driver;

import java.util.ArrayList;

import retoSofka.model.HistorialDAO;
import retoSofka.model.HistorialDTO;
import retoSofka.model.PendientesDAO;
import retoSofka.model.PendientesDTO;
import retoSofka.model.UsuarioDAO;

public class ManejoPuntaje {
	
	private int consultarID() {
		UsuarioDAO ua=new UsuarioDAO();
		int id;
		try {
			id=ua.leerByEstado(1);	
		} catch (Exception e) {
			id=0;
			System.out.println("error consultar id");
		}
		
		return id;
	}

	private int consultarCate() {
		int id=consultarID();
		if(id==0) {
			System.out.println("consulta id="+id);
			return 0;
		}else {
			PendientesDTO pt=new PendientesDTO();
			pt.setId_user(id);
			PendientesDAO pa=new PendientesDAO();
			pt=pa.consultar(pt);
			return pt.getCategoriaPregunta();
		}
		
		
	}
	

	public ArrayList<HistorialDTO> lista(){
		ArrayList<HistorialDTO> lista=new ArrayList<HistorialDTO>();
	
		HistorialDAO ha=new HistorialDAO();
		HistorialDTO ht=new HistorialDTO();
		ht.setId_user(consultarID());
		if(ht.getId_user()!=0) {
			System.out.println("Crear historial");
			
			
			
			lista=ha.registros(ht);
			ht.setNumeroIntento(lista.size()+1);
			ht.setPuntaje(consultarCate());
			lista.add(ht);
			ha.create(ht);
			UsuarioDAO usDAO = new UsuarioDAO(); 
			usDAO.cambiarEstado(consultarID(), 0);
			return lista;
		}
		
		
	
		
		
		return null;
	}
	
}
