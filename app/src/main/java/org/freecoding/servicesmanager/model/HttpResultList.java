package org.freecoding.servicesmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wowser on 2016/4/28.
 */
public class HttpResultList<T> implements Serializable {
    boolean success;
    int totalCount;
    String message;
    List<T> rows;
}
