package mmi.Server.controller;

import com.google.common.collect.Maps;
import mmi.Server.entity.Timer;
import mmi.Server.service.GalileoServiceImpl;
import mmi.Server.service.InputServiceImpl;
import mmi.Server.service.TimerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Robert on 1/13/2016.
 */
@Controller
@RequestMapping(value = "/timer")
public class TimerController
{

    private TimerServiceImpl timerService;
    private GalileoServiceImpl galileoService;
    private InputServiceImpl inputService;

    @Autowired
    public TimerController(TimerServiceImpl timerService, GalileoServiceImpl galileoService, InputServiceImpl inputService){
        this.timerService = timerService;
        this.galileoService = galileoService;
        this.inputService = inputService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView timers(){
        final Map<String, Object> model = Maps.newHashMap();
        model.put("timers", timerService.getAll());
        return new ModelAndView("timer/list", model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView getSaveTimer(){
        final Map<String, Object> model = Maps.newHashMap();
        model.put("outputs", inputService.getAll());
        model.put("galileos", galileoService.getAll());
        model.put("timer", new Timer());
        return new ModelAndView("timer/create", model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTimer(@ModelAttribute("timer") Timer timer){
        timerService.save(timer);
        return "redirect:/timer/";
    }

    @RequestMapping(value = "/toggle/{timerId}", method = RequestMethod.GET)
    public String toggleTimer(@PathVariable String timerId){
        Timer timer = timerService.getById(timerId);
        timer.setActive(!timer.isActive());
        timerService.save(timer);
        return "redirect:/timer/";
    }
}
