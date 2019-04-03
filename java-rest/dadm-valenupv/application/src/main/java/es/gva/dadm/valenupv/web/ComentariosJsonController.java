package es.gva.dadm.valenupv.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.gva.dadm.valenupv.model.Comentario;
import es.gva.dadm.valenupv.service.api.ComentarioService;

@Controller
@RequestMapping(value = "/api/comentarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComentariosJsonController {
	
	private ComentarioService comentarioService;
	/*
	 * Autowired constructor
	 * @param comnetarioService
	 */
	public ComentariosJsonController(ComentarioService comentarioService) {
		this.comentarioService = comentarioService;
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Comentario>> list() {
		final List<Comentario> result = comentarioService.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{comentarioId}")
	@ResponseBody
	public ResponseEntity<Comentario> showOne(@PathVariable Long comentarioId) {
		final Comentario result = comentarioService.findOne(comentarioId);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> create(@Valid @RequestBody Comentario comentario,
		BindingResult result) {
		if (comentario.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Comentario comentarioGuardado = comentarioService.save(comentario);
		return ResponseEntity.ok(comentarioGuardado);
	}
	
	@DeleteMapping(value = "/{comentarioId}")
	@ResponseBody
	public ResponseEntity<?> deleteOne(@PathVariable Long comentarioId) {
		Comentario comentarioGuardado = comentarioService.findOne(comentarioId);
		
		if (comentarioGuardado != null) {
			comentarioService.deleteById(comentarioId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
