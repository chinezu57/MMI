package mmi.Server.entity;

import mmi.Server.global.PinType;
import org.springframework.data.annotation.Id;

/**
 * Created by Robert on 1/13/2016.
 */
public class Output
{

    @Id
    private String Id;

    private String pin;
    private PinType pinType;
    private String galileoId;

    private Output(){

    }

    private Output(String pin, PinType pinType, String galileoId){
        this.pin = pin;
        this.pinType = pinType;
        this.galileoId = galileoId;
    }
}
