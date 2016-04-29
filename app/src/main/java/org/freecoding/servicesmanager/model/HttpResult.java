package org.freecoding.servicesmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wowser on 2016/4/28.
 */
public class HttpResult<T> implements Serializable {
    boolean success;
    String message;
    String responseNumber;
}
