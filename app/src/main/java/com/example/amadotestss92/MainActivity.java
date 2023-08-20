package com.example.amadotestss92;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPrice;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Amadeus amadeus = new FlightOffersPrice().getAmadeus();
            FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", "SYD")
                            .and("destinationLocationCode", "BKK")
                            .and("departureDate", "2024-01-01")
                            .and("returnDate", "2024-02-02")
                            .and("adults", 1)
                            .and("max", 2));

            // We price the 2nd flight of the list to confirm the price and the availability
            FlightPrice flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(
                    flightOffersSearches[1],
                    Params.with("include", "detailed-fare-rules")
                            .and("forceClass", "false")
            );

            TextView textView = (TextView) findViewById(R.id.test_amadeus);
            textView.setText(flightOffersSearches[0].getLastTicketingDate());
        } catch (ResponseException e) {
            e.printStackTrace();
        }
    }
}