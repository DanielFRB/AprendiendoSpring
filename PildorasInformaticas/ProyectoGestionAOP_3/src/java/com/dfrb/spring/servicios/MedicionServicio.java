package com.dfrb.spring.servicios;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class MedicionServicio {
    // Este servicio tiene un retardo programado de 4 segundos de duración
    public String getServicio() {
        System.out.println("*** METODO EJECUTANDOSE ***");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Servicio Finalizado";
    }
}
