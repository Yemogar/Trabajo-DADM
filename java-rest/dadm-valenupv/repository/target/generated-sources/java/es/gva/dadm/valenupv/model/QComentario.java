package es.gva.dadm.valenupv.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComentario is a Querydsl query type for Comentario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComentario extends EntityPathBase<Comentario> {

    private static final long serialVersionUID = -1294315017L;

    public static final QComentario comentario = new QComentario("comentario");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> paradaId = createNumber("paradaId", Long.class);

    public final StringPath titulo = createString("titulo");

    public final StringPath usuarioId = createString("usuarioId");

    public QComentario(String variable) {
        super(Comentario.class, forVariable(variable));
    }

    public QComentario(Path<? extends Comentario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComentario(PathMetadata metadata) {
        super(Comentario.class, metadata);
    }

}

