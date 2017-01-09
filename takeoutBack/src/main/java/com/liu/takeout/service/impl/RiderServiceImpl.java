package com.liu.takeout.service.impl;

import com.liu.takeout.dao.RiderMapper;
import com.liu.takeout.dao.RiderStatusMapper;
import com.liu.takeout.entity.Rider;
import com.liu.takeout.entity.RiderStatus;
import com.liu.takeout.service.RiderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by anybody on 2016/12/14.
 */

@Transactional
@Service
public class RiderServiceImpl implements RiderService{

    @Resource
    private RiderMapper riderMapper;

    @Resource
    private RiderStatusMapper riderStatusMapper;

    @Override
    public Map<Rider, RiderStatus> getRider(String search) {
        Rider r = new Rider();
        if (search!=null) {
            r.setName(search);
        }
        Map<Rider, RiderStatus> riderMap = new LinkedHashMap<>();
        for (Rider rider : riderMapper.getRiderList(r)){
            riderMap.put(rider,riderStatusMapper.selectByPrimaryKey(rider.getRiderStatusId()));
        }
        return riderMap;
    }

    @Override
    public int updateRiderStatus(Rider rider) {
        if(rider.getRiderStatusId()==1)
            rider.setRiderStatusId(2);
        else
            rider.setRiderStatusId(1);
        return riderMapper.updateRiderStatus(rider);
    }
}
