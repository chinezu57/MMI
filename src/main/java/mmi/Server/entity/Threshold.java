package mmi.Server.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by Robert on 1/13/2016.
 */
public class Threshold
{

    @Id
    private String id;

    private String inputId;
    private int threshold;
    private String outputId;

    public Threshold() {

    }

    public Threshold(String inputId, int threshold, String outputId){
        this.inputId = inputId;
        this.threshold = threshold;
        this.outputId = outputId;
    }
}
