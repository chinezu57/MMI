package mmi.Server.controller;

import com.google.common.collect.Maps;
import com.sun.javafx.sg.prism.NGShape;
import mmi.Server.entity.Galileo;
import mmi.Server.service.GalileoServiceImpl;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Robert on 1/5/2016.
 */
@Controller
public class MainController
{
    private GalileoServiceImpl galileoService;

    @Autowired
    public MainController(GalileoServiceImpl galileoService){
        this.galileoService = galileoService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String postGps()
    {
        return "index";
    }

    @RequestMapping(value = "/galileo", method = RequestMethod.GET)
    public ModelAndView getGalileo()
    {
        final Map<String, Object> model = Maps.newHashMap();
        model.put("galileo", new Galileo());
        return new ModelAndView("galileo/create", model);
    }

    @RequestMapping(value = "/galileo/save", method = RequestMethod.POST)
    public String saveGalileo(@ModelAttribute("galileo") final Galileo galileo){
        Validate.notNull(galileo);
        galileoService.saveGalileo(galileo);
        return "redirect:/galileo/list";
    }

    @RequestMapping(value = "/galileo/list", method = RequestMethod.GET)
    public ModelAndView listGalileo(ModelAndView modelAndView){
        List<Galileo> galileos = galileoService.getAll();
        modelAndView.getModel().put("galileos", galileos);
        modelAndView.setViewName("galileo/list");
        return modelAndView;
    }
}
