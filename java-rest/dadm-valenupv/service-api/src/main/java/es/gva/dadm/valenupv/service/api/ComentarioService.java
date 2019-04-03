package es.gva.dadm.valenupv.service.api;

import java.util.List;

import es.gva.dadm.valenupv.model.Comentario;

public interface ComentarioService {
	List<Comentario> findAll();
	Comentario findOne(Long id);
	Comentario save(Comentario comentario);
	void deleteById(Long id);
}
