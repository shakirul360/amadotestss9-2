package com.example.amadotestss92;

// How to install the library at https://github.com/amadeus4dev/amadeus-java

import com.amadeus.Amadeus;

public class FlightOffersPrice {

    private Amadeus amadeus;

    public Amadeus getAmadeus() {
        if (amadeus != null) {
            return amadeus;
        }
        amadeus = Amadeus
                .builder("2REuWM81FiAZlE8Gz3V0OtnS3hWZcmUA", "r1BgDDQoFBjihcQO")
                .build();
        return amadeus;
    }
}
