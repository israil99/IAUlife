package main.java.iaulife.controller;

import main.java.iaulife.handler.DataBaseHanlder;

import java.awt.*;

public class MainControllerExtendedVersion extends DataBaseHanlder {
    private Button newsButton ;
    private Button eventsButton;
    private Button announcementsButton;
    private Button scheduleButton;
    private Button logOutButton;
    private Button addNews;
    private Button addEvents;
    private Button addAnnouncements;
    private Button showLog;

    void initialize(){}

    @Override
    public void getAnnouncements() {
        super.getAnnouncements();
    }

    @Override
    public void getLog() {
        super.getLog();
    }

    @Override
    public void getNews() {
        super.getNews();
    }

    @Override
    public void getSchedule() {
        super.getSchedule();
    }

    @Override
    public void getEvents() {
        super.getEvents();
    }

    @Override
    public void addEvents() {
        super.addEvents();
    }

    @Override
    public void addLog() {
        super.addLog();
    }

    @Override
    public void addNews() {
        super.addNews();
    }
}
