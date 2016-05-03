package org.freecoding.servicesmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wowser on 2016/4/28.
 */
public class HttpResultList<T> implements Serializable {
    public boolean success;
    public int totalCount;
    public String message;
    public List<T> rows;
}
