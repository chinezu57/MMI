package mmi.Server.service;

import mmi.Server.entity.Timer;
import mmi.Server.repository.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 1/13/2016.
 */
@Service
public class TimerServiceImpl
{

    private TimerRepository timerRepository;
    private GalileoServiceImpl galileoService;
    private InputServiceImpl inputService;

    @Autowired
    public TimerServiceImpl(TimerRepository timerRepository, GalileoServiceImpl galileoService, InputServiceImpl inputService){
        this.timerRepository = timerRepository;
        this.galileoService = galileoService;
        this.inputService = inputService;
    }

    public void save(Timer timer){
        timer.setTimeRemaining(timer.getTimer());
        timer.setActive(true);
        timerRepository.save(timer);
    }

    public void delete(Timer timer){
        timerRepository.delete(timer);
    }

    public List<Timer> getAll(){
        return timerRepository.findAll();
    }

    @Scheduled(fixedRate=1000)
    public void timerTicks(){
        System.out.println("Timer Check");
        List<Timer> timers = timerRepository.findAll();
        for (Timer timer : timers)
        {
            if(timer.isActive())
            {
                if (timer.getTimeRemaining() <= 0)
                {
                    galileoService.togglePin(inputService.getById(timer.getOutputId()));
                    if (timer.isLoop())
                    {
                        timer.setTimeRemaining(timer.getTimer());
                        timerRepository.save(timer);
                    }
                }
                else
                {
                    timer.setTimeRemaining(timer.getTimeRemaining() - 1);
                    timerRepository.save(timer);
                }
            }
        }
    }

    public Timer getById(String timerId)
    {
        return timerRepository.findOne(timerId);
    }
}
