/**
 * Copyright (c) 2017 Generalitat Valenciana - Todos los derechos reservados.
 */
package es.gva.dadm.valenupv.config;

import es.gva.dadm.valenupv.security.CustomAccessDeniedHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.accept.ContentNegotiationStrategy;

/**
 * Configuración de seguridad.
 *
 * <p>
 * Clase con la configuración base de la capa de seguridad.
 * </p>
 *
 * @author lalonso at http://www.disid.com[DISID Corporation S.L.]
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  // Recursos públicos: css, webjars, errores, index, api
  private static final String[] URLS_PUBLICAS = {"/api/**"};

  /** Duración máxima de la sesión de usuario */
  @Value("${security.maximum-concurrent-sessions}")
  protected Integer sesionesConcurrentes;

  /**
   * Constructor por defecto.
   */
  public SecurityConfiguration() {
    super();
  }

  /**
   * {@inheritDoc}
   * 
   * Permisos de acceso a URLs y configuración de la sesión.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Desactivar acceso por usuario/clave en cabecera HTTP
    http.httpBasic().disable();

    http.sessionManagement().maximumSessions(sesionesConcurrentes);

    http.exceptionHandling()
        .accessDeniedHandler(new CustomAccessDeniedHandler());
  }

  /**
   * {@inheritDoc}
   * 
   * No aplicar los filtros de seguridad en las URLs públicas.
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);

    web.ignoring().antMatchers(getUrlsPublicas());
  }

  /**
   * {@inheritDoc}
   * 
   * Debido a un error conocido por parte de la librería Spring Security, es
   * necesario sobreescribir este método para indicar que el Content Negotiation
   * Strategy que se utilizará es el que se encuentra actualmente en el contexto
   * de Spring. Si no se sobreescribe este método, no se registran de forma
   * correcta los formateadores y conversores de entidades.
   * 
   * @see https://github.com/spring-projects/spring-security/issues/4202
   */
  @Override
  public void setContentNegotationStrategy(
      ContentNegotiationStrategy contentNegotiationStrategy) {
    super.setContentNegotationStrategy(contentNegotiationStrategy);
  }

  /**
   * @return the urlsPublicas
   */
  public static String[] getUrlsPublicas() {
    return URLS_PUBLICAS.clone();
  }

}
