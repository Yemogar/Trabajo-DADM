package es.gva.dadm.valenupv.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import es.gva.dadm.valenupv.model.Comentario;

@Transactional(readOnly = true)
public class ComentarioRepositoryImpl extends QueryDslRepositorySupport
	implements ComentarioRepositoryCustom {

	public ComentarioRepositoryImpl() {
		super(Comentario.class);
	}
}
