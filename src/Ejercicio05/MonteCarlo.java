package Ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class MonteCarlo {
    private RegionCuadrada region;
    private List<Coordenada> coordenadas;

    public MonteCarlo(RegionCuadrada region) {
        this.region = region;
        this.coordenadas = new ArrayList<>();
    }

    public RegionCuadrada getRegion() {
        return region;
    }



    public void agregarCoordenada(Coordenada coordenada) {
        if (region.contains(coordenada)) {
            coordenadas.add(coordenada);
        }
    }

    public List<Coordenada> getCoordenadas() {
        return new ArrayList<>(this.coordenadas);
    }
}
