/**
 * Copyright (c) 2017 Generalitat Valenciana - Todos los derechos reservados.
 */
package es.gva.dadm.valenupv.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * Manejador de excepciones de la aplicación.
 *
 * <p>
 * La anotación {@link ControllerAdvice} es detectada automáticamente por Spring
 * MVC y aplicará el aspecto implementado a todos los métodos anotados con
 * {@link RequestMapping}, en el caso de esta clase el aspecto implementado es
 * {@link ExceptionHandler}, gestión de excepciones.
 * </p>
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

  /** Interfaz para resolver mensajes en la aplicación */
  private final MessageSource messageSource;

  /** Implementación de logging para mostrar trazas */
  private static final Logger LOG =
      LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

  /**
   * Constructor de la clase e inyección de dependencias.
   *
   * @param messageSource Mensajes multi idioma.
   */
  @Autowired
  public ExceptionHandlerAdvice(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

}
