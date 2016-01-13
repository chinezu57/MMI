package mmi.Server.service;

import com.sun.deploy.net.HttpResponse;
import mmi.Server.entity.Galileo;
import mmi.Server.entity.Input;
import mmi.Server.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Robert on 1/13/2016.
 */
@Service
public class InputServiceImpl
{
    private InputRepository inputRepository;
    private final String USER_AGENT = "Mozilla/5.0";

    @Autowired
    public InputServiceImpl(InputRepository inputRepository)
    {
        this.inputRepository = inputRepository;
    }

    public void saveInput(Input input){
        inputRepository.save(input);
    }

    public void deleteInput(Input input){
        inputRepository.delete(input);
    }

    public List<Input> getAll(){
        return inputRepository.findAll();
    }

    public Input getById(String id){
        return inputRepository.findOne(id);
    }

}
