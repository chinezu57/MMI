package mmi.Server.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by Robert on 1/12/2016.
 */
public class Galileo
{
    @Id
    private String id;

    private String name;
    private String ipAddress;
    private String location;

    public Galileo()
    {
        //default constructor for jackson
    }

    public Galileo(String name, String ipAddress, String location)
    {
        this.name = name;
        this.ipAddress = ipAddress;
        this.location = location;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
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
