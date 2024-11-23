package com.conference.model;


import java.util.ArrayList;
import java.util.List;

public class Track {
    private final List<Talk> morningSession = new ArrayList<>();
    private final List<Talk> afternoonSession = new ArrayList<>();

    public void addTalkToMorning(Talk talk) {
        morningSession.add(talk);
    }

    public void addTalkToAfternoon(Talk talk) {
        afternoonSession.add(talk);
    }

    public List<Talk> getMorningSession() {
        return morningSession;
    }

    public List<Talk> getAfternoonSession() {
        return afternoonSession;
    }

    public int getMorningSessionDuration() {
        return morningSession.stream().mapToInt(Talk::getDuration).sum();
    }

    public int getAfternoonSessionDuration() {
        return afternoonSession.stream().mapToInt(Talk::getDuration).sum();
    }

   
}
