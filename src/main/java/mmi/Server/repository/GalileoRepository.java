package mmi.Server.repository;

import mmi.Server.entity.Galileo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Robert on 1/12/2016.
 */
public interface GalileoRepository extends MongoRepository<Galileo, String>
{

}
