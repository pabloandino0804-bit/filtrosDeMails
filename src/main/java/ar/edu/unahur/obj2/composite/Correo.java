package ar.edu.unahur.obj2.composite;

public class Correo {
    private String asunto;
    private Integer tamanioKB;
    private Boolean tieneAdjunto = true;
    private String cuerpo;
    
    public Correo(String asunto, Integer tamanioKB, String cuerpo){
        this.asunto = asunto;
        this.tamanioKB = tamanioKB;
        this.cuerpo = cuerpo;
    }

    public Correo(String asunto, Integer tamanioKB, Boolean adjunto, String cuerpo){
        this.asunto = asunto;
        this.tamanioKB = tamanioKB;
        this.tieneAdjunto = adjunto;
        this.cuerpo = cuerpo;
    }

    public String getAsunto() {
        return asunto;
    }

    public Integer getTamanioKB() {
        return tamanioKB;
    }

    public Boolean tieneAdjuntos() {
        return tieneAdjunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }
}