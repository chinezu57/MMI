package mmi.Server.service;

import mmi.Server.entity.Galileo;
import mmi.Server.entity.Input;
import mmi.Server.entity.Sensor;
import mmi.Server.global.PinType;
import mmi.Server.repository.GalileoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Robert on 1/12/2016.
 */
@Service
public class GalileoServiceImpl
{
    private GalileoRepository galileoRepository;
    private InputServiceImpl inputService;
    private final String USER_AGENT = "Mozilla/5.0";

    @Autowired
    public GalileoServiceImpl(GalileoRepository galileoRepository, InputServiceImpl inputService)
    {
        this.galileoRepository = galileoRepository;
        this.inputService = inputService;
    }

    public void saveGalileo(Galileo galileo){
        galileoRepository.save(galileo);
        for(int i=2;i<=13;i++){
            Input input = new Input();
            input.setGalileoId(galileo.getId());
            input.setPin(""+i);
            input.setPinType(PinType.DIGITAL);
            inputService.saveInput(input);
        }
        for(int i=0;i<=5;i++){
            Input input = new Input();
            input.setGalileoId(galileo.getId());
            input.setPin("A"+i);
            input.setPinType(PinType.ANALOG);
            inputService.saveInput(input);
        }
    }

    public void deleteGalileo(Galileo galielo){
        galileoRepository.delete(galielo);
    }

    public List<Galileo> getAll()
    {
        return galileoRepository.findAll();
    }

    public Galileo getById(String galileoId){
        return galileoRepository.findOne(galileoId);
    }

    public void togglePin(Input input){

        try
        {
            Galileo galileo = this.getById(input.getGalileoId());
            String url = "http://"+galileo.getIpAddress()+":3000/digitalPin/"+input.getPin()+"/toggle";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        }
        catch(Exception e){
            //handle this shit
        }

    }

    public int getSensorValue(Sensor sensor){
        try
        {
            Galileo galileo = this.getById(sensor.getGalileoId());
            String url = "http://"+galileo.getIpAddress()+":3000/digitalPin/"+sensor.getInputPinId();

            //            URL obj = new URL(url);
            //            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //
            //            con.setRequestMethod("GET");
            //
            //            con.setRequestProperty("User-Agent", USER_AGENT);
            //
            //            int responseCode = con.getResponseCode();
            //            System.out.println("\nSending 'GET' request to URL : " + url);
            //            System.out.println("Response Code : " + responseCode);
            //
            //            BufferedReader in = new BufferedReader(
            //                new InputStreamReader(con.getInputStream()));
            //            String inputLine;
            //            StringBuffer response = new StringBuffer();
            //
            //            while ((inputLine = in.readLine()) != null)
            //            {
            //                response.append(inputLine);
            //            }
            //            in.close();
            //
            //            System.out.println(response.toString());
        }
        catch(Exception e){
            //handle this shit
        }
        return 1;
    }
}
