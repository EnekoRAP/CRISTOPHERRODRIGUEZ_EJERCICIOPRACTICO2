package com.Prueba2.service.impl;

import com.Prueba2.dao.HotelesDao;
import com.Prueba2.domain.Hoteles;
import com.Prueba2.service.HotelesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelesServiceImpl implements HotelesService {
    @Autowired
    private HotelesDao hotelDao;
    
    
    @Transactional(readOnly=true)
    @Override
    public List<Hoteles> getHoteles() {
        var lista=hotelDao.findAll();
        return lista;
    }

     @Override
    @Transactional(readOnly = true)
    public Hoteles getHotel(Hoteles hotel) {
        return hotelDao.findById(hotel.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Hoteles hotel) {
        hotelDao.save(hotel);
    }

    @Override
    @Transactional
    public void delete(Hoteles hotel) {
        hotelDao.delete(hotel);
    }
}
