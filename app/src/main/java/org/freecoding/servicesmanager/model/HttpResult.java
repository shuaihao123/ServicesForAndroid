package org.freecoding.servicesmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wowser on 2016/4/28.
 */
public class HttpResult implements Serializable {
    public boolean success;
    public  String message;
    public  String responseNumber;
}
