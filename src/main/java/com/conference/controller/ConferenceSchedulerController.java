package com.conference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conference.model.Talk;
import com.conference.model.Track;
import com.conference.service.ConferenceSchedulerService;
import com.conference.util.TimeUtil;

@RestController
@RequestMapping("/api/scheduler")
public class ConferenceSchedulerController {

	@Autowired
    private ConferenceSchedulerService schedulerService;

    @PostMapping("/schedule")
    public String scheduleTalks(@RequestBody List<Talk> talks) {
        return schedulerService.scheduleAllTalks(talks);
    }
}
