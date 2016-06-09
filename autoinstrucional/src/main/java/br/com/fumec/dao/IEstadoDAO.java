package br.com.fumec.dao;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.fumec.models.Estado;

public interface IEstadoDAO extends Serializable {

	public Response createEstado(Estado estado);
	
	public List<Estado> findAll();
	
}
