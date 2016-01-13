package mmi.Server.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by Robert on 1/13/2016.
 */
public class Sensor
{
    @Id
    private String id;

    private String name;
    private String inputPinId;
    private String galileoId;
    private String location;
    private int poolingTime;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getInputPinId()
    {
        return inputPinId;
    }

    public void setInputPinId(String inputPinId)
    {
        this.inputPinId = inputPinId;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getPoolingTime()
    {
        return poolingTime;
    }

    public void setPoolingTime(int poolingTime)
    {
        this.poolingTime = poolingTime;
    }

    public String getGalileoId()
    {
        return galileoId;
    }

    public void setGalileoId(String galileoId)
    {
        this.galileoId = galileoId;
    }
}
