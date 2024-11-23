package com.conference.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.conference.model.Talk;

public class TimeUtil {

	public static String formatSession(List<Talk> talks, int startTimeMinutes) {
        StringBuilder session = new StringBuilder();
        LocalTime time = LocalTime.of(startTimeMinutes / 60, startTimeMinutes % 60);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");

        for (Talk talk : talks) {
            session.append(time.format(formatter).toUpperCase()) // Ensures AM/PM in uppercase
                   .append(" ")
                   .append(talk)
                   .append("\n");
            time = time.plusMinutes(talk.getDuration());
        }

        return session.toString();
    }
}

