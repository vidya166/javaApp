package com.vidya.crud.models;

import lombok.Data;

@Data
public class GeoLocation {

	private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
