package mmi.Server.service;

import mmi.Server.entity.Sensor;
import mmi.Server.entity.Timer;
import mmi.Server.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 1/13/2016.
 */
@Service
public class SensorServiceImpl
{
    private SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository){
        this.sensorRepository = sensorRepository;
    }

    public void saveSensor(Sensor sensor){
        sensorRepository.save(sensor);
    }

    public void deleteSensor(Sensor sensor){
        sensorRepository.delete(sensor);
    }

    public List<Sensor> getAll()
    {
        return sensorRepository.findAll();
    }

    @Scheduled(fixedRate=1000)
    public void SensorTick(){
        System.out.println("Sensor Check");
        List<Sensor> sensors = sensorRepository.findAll();
        for (Sensor sensor : sensors)
        {

        }
    }
}
