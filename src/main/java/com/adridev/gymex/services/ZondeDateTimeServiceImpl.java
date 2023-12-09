package com.adridev.gymex.services;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Service
public class ZondeDateTimeServiceImpl implements ZoneDateTimeService{
    @Override
    public ZonedDateTime getZoneDateTime(String zone) {
        return ZonedDateTime.now(ZoneId.of(zone));
    }
}
