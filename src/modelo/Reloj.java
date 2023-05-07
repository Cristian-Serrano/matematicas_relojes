package modelo;

public class Reloj {
    private int anteriorPosicionAguja;
    private int posicionAguja;
    private int tiempoTranscurrido;

    public Reloj() {
        anteriorPosicionAguja = 0;
        posicionAguja = 0;
        tiempoTranscurrido = 0;
    }

    public Reloj(int anteriorPosicionAguja, int posicionAguja, int tiempoTranscurrido) {
        this.anteriorPosicionAguja = anteriorPosicionAguja;
        this.posicionAguja = posicionAguja;
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    public int getAnteriorPosicionAguja() {
        return anteriorPosicionAguja;
    }
    public int getPosicionAguja() {
        return posicionAguja;
    }

    public int getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public int avanzarSentidoHorario() {
        this.anteriorPosicionAguja = posicionAguja;
        this.posicionAguja += 1;
        this.tiempoTranscurrido += 1;
        return posicionAguja;
    }

    public int avanzarSentidoAntihorario() {
        this.anteriorPosicionAguja = posicionAguja;
        this.posicionAguja += -1;
        this.tiempoTranscurrido += 1;
        return posicionAguja;
    }

    @Override
    public String toString() {
        return "\n->  "+posicionAguja+"\t(Anterior: "+anteriorPosicionAguja+")\t (Tiempo: "+tiempoTranscurrido+" s)";
    }
    
}
