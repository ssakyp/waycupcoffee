package kz.solva.service;

import jakarta.annotation.PostConstruct;
import kz.solva.client.HolidaysRequestClient;
import kz.solva.payload.HolidayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CacheService {

    @Autowired
    private HolidaysRequestClient holidaysRequestClient;

    @PostConstruct
    public void init() {
        parseHolidays();
    }

    @Cacheable(value = "holidays", key = "'holidays'")
    public List<String> parseHolidays() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        List<String> result = new ArrayList<>();
        List<HolidayResponse> responses = holidaysRequestClient.getHolidays(formatter.format(date));
        for (HolidayResponse response : responses) {
            result.add(response.getDate());
        }
        return result;
    }

}
