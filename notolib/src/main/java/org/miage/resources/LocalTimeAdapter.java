package org.miage.resources;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
    @Override
    public LocalTime unmarshal(String timeString) throws Exception {
        return LocalTime.parse(timeString, DateTimeFormatter.ISO_TIME);
    }

    @Override
    public String marshal(LocalTime localTime) throws Exception {
        return DateTimeFormatter.ISO_TIME.format(localTime);
    }
}
