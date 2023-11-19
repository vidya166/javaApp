package com.vidya.crud.req;

import lombok.Data;

@Data
public class City {
     
	private long cityId;

    public long getCityId() {
        return cityId;
    }
}
