package mmi.Server.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by Robert on 1/13/2016.
 */
public class Timer
{
    @Id
    private String id;

    private String galileoId;
    private String outputId;
    private int timer;
    private int timeRemaining;
    private boolean loop;
    private boolean active;

    public Timer(){

    }

    public Timer(String outputId, int timer){
        this.outputId = outputId;
        this.timer = timer;
    }

    public String getGalileoId()
    {
        return galileoId;
    }

    public void setGalileoId(String galileoId)
    {
        this.galileoId = galileoId;
    }

    public String getOutputId()
    {
        return outputId;
    }

    public void setOutputId(String outputId)
    {
        this.outputId = outputId;
    }

    public int getTimer()
    {
        return timer;
    }

    public void setTimer(int timer)
    {
        this.timer = timer;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getTimeRemaining()
    {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining)
    {
        this.timeRemaining = timeRemaining;
    }

    public boolean isLoop()
    {
        return loop;
    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
}
