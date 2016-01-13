package mmi.Server.controller;

import com.google.common.collect.Maps;
import mmi.Server.entity.Sensor;
import mmi.Server.service.GalileoServiceImpl;
import mmi.Server.service.InputServiceImpl;
import mmi.Server.service.SensorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Robert on 1/13/2016.
 */
@Controller
@RequestMapping("/sensor")
public class SensorController
{
    private SensorServiceImpl sensorService;
    private GalileoServiceImpl galileoService;
    private InputServiceImpl inputService;

    @Autowired
    public SensorController(SensorServiceImpl sensorService, GalileoServiceImpl galileoService, InputServiceImpl inputService){
        this.sensorService = sensorService;
        this.galileoService = galileoService;
        this.inputService = inputService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getSensors(){
        final Map<String, Object> model = Maps.newHashMap();
        model.put("sensors", sensorService.getAll());
        return new ModelAndView("sensor/list", model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView getSaveSensors(){
        final Map<String, Object> model = Maps.newHashMap();
        model.put("outputs", inputService.getAll());
        model.put("galileos", galileoService.getAll());
        model.put("sensor", new Sensor());
        return new ModelAndView("sensor/create", model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSensors(@ModelAttribute("sensor") Sensor sensor){
        sensorService.saveSensor(sensor);
        return "redirect:/sensor/";
    }
}
