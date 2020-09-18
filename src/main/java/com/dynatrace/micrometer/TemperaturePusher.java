package com.dynatrace.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

@Component
public class TemperaturePusher {

    private static final List<City> CITIES = asList(
            new City("Barcelona", "Spain", "Europe"),
            new City("Linz", "Austria", "Europe"),
            new City("Gdansk", "Poland", "Europe"),
            new City("Detroit", "United States", "America")
    );

    private final MeterRegistry meterRegistry;

    @Autowired
    public TemperaturePusher(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void registerMetricPush() {
        CITIES.forEach(city -> meterRegistry.gauge(
                "temperature",
                asList(
                        Tag.of("city", city.name),
                        Tag.of("country", city.country),
                        Tag.of("continent", city.continent)),
                city,
                (City doesNotMatter) -> new Random().nextInt(40)
        ));
    }

    private static class City {
        final String name;
        final String country;
        final String continent;

        City(final String name, final String country, final String continent) {
            this.name = name;
            this.country = country;
            this.continent = continent;
        }
    }
}
