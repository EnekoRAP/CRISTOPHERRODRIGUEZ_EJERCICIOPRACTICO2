package com.Prueba2.service;

import com.Prueba2.domain.Hoteles;
import java.util.List;

public interface HotelesService {
   
    public List<Hoteles> getHoteles();

 
    public Hoteles getHotel(Hoteles hotel);
    
 
    public void save(Hoteles hotel);
    
  
    public void delete(Hoteles hotel);
}
