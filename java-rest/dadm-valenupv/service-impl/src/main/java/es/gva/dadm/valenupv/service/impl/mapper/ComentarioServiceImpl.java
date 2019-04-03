package es.gva.dadm.valenupv.service.impl.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.gva.dadm.valenupv.model.Comentario;
import es.gva.dadm.valenupv.repository.ComentarioRepository;
import es.gva.dadm.valenupv.service.api.ComentarioService;

@Transactional(readOnly = true)
@Component
public class ComentarioServiceImpl implements ComentarioService {
	
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	@Override
	public List<Comentario> findAll() {
		return comentarioRepository.findAll();
	}
	
	@Override
	@Transactional
	public Comentario save(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		comentarioRepository.delete(id);
	}
	
	@Override
	public Comentario findOne(Long id) {
		return comentarioRepository.findOne(id);
	}

}
