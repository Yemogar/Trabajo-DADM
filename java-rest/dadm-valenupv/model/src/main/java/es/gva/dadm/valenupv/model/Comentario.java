package es.gva.dadm.valenupv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="COMENTARIO")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentarioGen")
	@SequenceGenerator(name = "comentarioGen", sequenceName = "COMENTARIO_SEQ")
	private Long id;
	
	@Column(name = "TITULO")
	@Size(max = 255)
	@NotNull
	private String titulo;
	
	@Column(name = "DESCRIPCION")
	@Size(max = 255)
	@NotNull
	private String descripcion;
	
	@Column(name = "PARADA_ID")
	@NotNull
	private Long paradaId;
	
	@Column(name = "USUARIO_ID")
	@Size(max = 255)
	@NotNull
	private String usuarioId;

	public Comentario() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getParadaId() {
		return paradaId;
	}

	public void setParadaId(Long paradaId) {
		this.paradaId = paradaId;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
