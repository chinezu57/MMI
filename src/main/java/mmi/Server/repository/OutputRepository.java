package mmi.Server.repository;

import mmi.Server.entity.Output;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Robert on 1/13/2016.
 */
public interface OutputRepository extends MongoRepository<Output, String>
{
}
