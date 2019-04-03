package es.gva.dadm.valenupv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import es.gva.dadm.valenupv.model.Comentario;

@Transactional(readOnly = true)
public interface ComentarioRepository extends ComentarioRepositoryCustom,
	JpaRepository<Comentario, Long>{

}
