package com.conference.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.conference.model.Talk;
import com.conference.model.Track;
import com.conference.util.TimeUtil;

@Service
public class ConferenceSchedulerService {

	public String scheduleAllTalks(List<Talk> talks) {
    	List<Track> tracks = scheduleTalks(talks);

        StringBuilder output = new StringBuilder();
        int trackNumber = 1;

        for (Track track : tracks) {
            output.append("Track ").append(trackNumber++).append(":\n");
            int time = 9 * 60; // 9:00 AM
            output.append(TimeUtil.formatSession(track.getMorningSession(), time));
            output.append("12:00PM Lunch\n");
            time = 13 * 60; // 1:00 PM
            output.append(TimeUtil.formatSession(track.getAfternoonSession(), time));
            output.append("04:00PM Networking Event\n\n");
        }

        return output.toString().trim();
    }
	
    public List<Track> scheduleTalks(List<Talk> talks) {
        List<Track> tracks = new ArrayList<>();
        List<Talk> remainingTalks = new ArrayList<>(talks);

        while (!remainingTalks.isEmpty()) {
            Track track = new Track();
            fillSession(track.getMorningSession(), remainingTalks, 180); // Morning: 9 AM - 12 PM
            fillSession(track.getAfternoonSession(), remainingTalks, 240); // Afternoon: 1 PM - 4 PM
            tracks.add(track);
        }

        return tracks;
        
    }

    private void fillSession(List<Talk> session, List<Talk> talks, int maxDuration) {
        int totalDuration = 0;

        for (int i = 0; i < talks.size(); i++) {
            Talk talk = talks.get(i);
            if (totalDuration + talk.getDuration() <= maxDuration) {
                session.add(talk);
                totalDuration += talk.getDuration();
                talks.remove(i);
                i--; // Adjust index after removal
            }
        }
    }
}

