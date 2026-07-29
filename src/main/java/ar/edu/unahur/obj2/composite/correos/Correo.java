package ar.edu.unahur.obj2.composite.correos;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroDefecto;

public class Correo {
    private String remitente;
    private String destinatario;
    private String asunto;
    private Double tamanio;
    private Boolean archivosAdjuntos;
    private String cuerpo;

    private IFiltro filtro;
    
    public Correo(String remitente, String destinatario, String asunto, Double tamanio, Boolean archivosAdjuntos,
            String cuerpo) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.tamanio = tamanio;
        this.archivosAdjuntos = archivosAdjuntos;
        this.cuerpo = cuerpo;
        filtro = new FiltroDefecto(this);
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public Boolean getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public Boolean filtrar(){
        return filtro.aplicar();
    }

}
