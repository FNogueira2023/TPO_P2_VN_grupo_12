package Ejercicio05;

public class RegionCuadrada {
    private final Coordenada coordenada;
    private final int longitudLado;


    public RegionCuadrada(Coordenada coordenada, int longitudLado) {
        if (coordenada.retornarCuadrante() != 1){
            throw new RuntimeException("Debe estar en primer cuadrante");
        }

        if (longitudLado <= 0){
            throw new RuntimeException("La longitud debe ser mayor a 0");
        }
        this.coordenada = coordenada;
        this.longitudLado = longitudLado;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public int getLongitudLado() {
        return longitudLado;
    }

    public boolean contains(Coordenada coordenada) {
        int x = coordenada.getX();
        int y = coordenada.getY();
        int x0 = this.coordenada.getX();
        int y0 = this.coordenada.getY();

        return (x >= x0 && x <= x0 + longitudLado) && (y >= y0 && y <= y0 + longitudLado);
    }
}
