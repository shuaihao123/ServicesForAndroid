package org.freecoding.servicesmanager.model;

import java.io.Serializable;

/**
 * Created by Wowser on 2016/4/28.
 */
public class Order implements Serializable{
    int serviceId;
    String serviceTime;
    String serviceItem;
    String name;
    String address;
    String phone;
}
