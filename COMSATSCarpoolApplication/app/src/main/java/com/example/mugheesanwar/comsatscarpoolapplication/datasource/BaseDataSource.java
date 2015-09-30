package com.example.mugheesanwar.comsatscarpoolapplication.datasource;

import java.util.Observable;

/**
 * Created by mugheesanwar on 20/09/15.
 */
public class BaseDataSource extends Observable {
    protected void triggerObservers() {
        setChanged();
        notifyObservers();
    }
}