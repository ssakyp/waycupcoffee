package kz.solva.client;

import kz.solva.payload.HolidayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "HolidayRequestClient", url = "https://date.nager.at/api/v3/publicholidays")
public interface HolidaysRequestClient {

    @GetMapping("/{year}/KZ")
    List<HolidayResponse> getHolidays(@PathVariable("year") String year);

}
