package com.liu.takeout.service;

import com.liu.takeout.entity.Rider;
import com.liu.takeout.entity.RiderStatus;

import java.util.Map;

/**
 * Created by anybody on 2016/12/14.
 */
public interface RiderService {
    Map<Rider,RiderStatus> getRider(String serach);
    int updateRiderStatus(Rider rider);
}
