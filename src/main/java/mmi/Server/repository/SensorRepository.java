package mmi.Server.repository;

import mmi.Server.entity.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Robert on 1/13/2016.
 */
public interface SensorRepository extends MongoRepository<Sensor, String>
{
}
