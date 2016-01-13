package mmi.Server.repository;

import mmi.Server.entity.Threshold;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Robert on 1/13/2016.
 */
public interface ThresholdRepository extends MongoRepository<Threshold, String>
{
}
