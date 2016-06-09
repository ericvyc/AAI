package br.com.fumec.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.fumec.dao.IEstadoDAO;
import br.com.fumec.models.Estado;

public class EstadoDAO implements IEstadoDAO {

	private static final long serialVersionUID = 3459713197334261189L;
	
	private List<Estado> estados = new ArrayList<Estado>();

	@Override
	public Response createEstado(Estado estado) {
		estados.add(estado);
		return Response.ok().build();
	}

	@Override
	public List<Estado> findAll() {
		return estados;
	}
	
}
