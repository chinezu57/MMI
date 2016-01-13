package mmi.Server.service;

import mmi.Server.entity.Output;
import mmi.Server.repository.OutputRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Robert on 1/13/2016.
 */
public class OutputServiceImpl
{
    private OutputRepository outputRepository;

    @Autowired
    public OutputServiceImpl(OutputRepository outputRepository)
    {
        this.outputRepository = outputRepository;
    }

    public void saveOutput(Output output){
        outputRepository.save(output);
    }

    public void deleteOutput(Output output){
        outputRepository.delete(output);
    }
}
