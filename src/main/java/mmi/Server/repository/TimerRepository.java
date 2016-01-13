package mmi.Server.repository;

import mmi.Server.entity.Timer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Robert on 1/13/2016.
 */
public interface TimerRepository extends MongoRepository<Timer, String>
{
}
