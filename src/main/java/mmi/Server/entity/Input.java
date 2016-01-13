package mmi.Server.entity;

import mmi.Server.global.PinType;
import org.springframework.data.annotation.Id;

/**
 * Created by Robert on 1/12/2016.
 */
public class Input
{
    @Id
    private String id;

    private String pin;
    private PinType pinType;
    private String galileoId;

    public Input(){

    };
    public Input(String pin, PinType pinType, String galileoId){
        this.pin = pin;
        this.pinType = pinType;
        this.galileoId = galileoId;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public PinType getPinType()
    {
        return pinType;
    }

    public void setPinType(PinType pinType)
    {
        this.pinType = pinType;
    }

    public String getGalileoId()
    {
        return galileoId;
    }

    public void setGalileoId(String galileoId)
    {
        this.galileoId = galileoId;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
