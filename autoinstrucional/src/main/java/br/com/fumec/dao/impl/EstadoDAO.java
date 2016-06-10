package br.com.fumec.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import br.com.fumec.dao.IEstadoDAO;
import br.com.fumec.models.Estado;
import br.com.fumec.models.Pessoa;

public class EstadoDAO implements IEstadoDAO {

	private static final long serialVersionUID = 3459713197334261189L;
	
	private List<Estado> estados = new ArrayList<Estado>();

	@Override
	public Response createEstado(Estado estado) {
		estados.add(estado);
		return Response.ok().build();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findAll() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoinstrucional");
		EntityManager em = emf.createEntityManager();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_pessoa limit 5 ");
		
		Query query = em.createNativeQuery(sb.toString(), Pessoa.class);
		
		return query.getResultList();
	}
	
}
