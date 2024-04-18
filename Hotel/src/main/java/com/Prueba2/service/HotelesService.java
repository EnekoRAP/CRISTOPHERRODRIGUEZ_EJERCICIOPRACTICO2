package com.Prueba2.service;

import com.Prueba2.domain.Hoteles;
import java.util.List;

public interface HotelesService {
    
    public List<Hoteles> getHoteles(boolean activo);

    // Se obtiene un Vuelo, a partir del id de un vuelo
    public Hoteles getVuelos(Hoteles hoteles);
    
    // Se inserta un nuevo vuelo si el id del vuelo esta vacío
    // Se actualiza un vuelo si el id del vuelo NO esta vacío
    public void save(Hoteles hoteles);
    
    // Se elimina el vuelo que tiene el id pasado por parámetro
    public void delete(Hoteles hoteles);
    
}
