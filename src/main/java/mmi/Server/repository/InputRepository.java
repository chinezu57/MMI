package mmi.Server.repository;

import mmi.Server.entity.Input;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Robert on 1/13/2016.
 */
public interface InputRepository extends MongoRepository<Input, String>
{

}
