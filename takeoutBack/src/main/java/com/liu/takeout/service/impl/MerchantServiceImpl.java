package com.liu.takeout.service.impl;

import com.liu.takeout.dao.MerchantMapper;
import com.liu.takeout.dao.MerchantStatusMapper;
import com.liu.takeout.entity.Merchant;
import com.liu.takeout.entity.MerchantStatus;
import com.liu.takeout.service.MerchantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by anybody on 2016/12/13.
 */
@Transactional
@Service
public class MerchantServiceImpl implements MerchantService{

    @Resource
    private MerchantMapper merchantMapper;

    @Resource
    private MerchantStatusMapper merchantStatusMapper;

    @Override
    public Map<Merchant, MerchantStatus> getMerchant(String search) {
        Merchant m = new Merchant();
        if (search!=null) {
            m.setName(search);
        }
        Map<Merchant, MerchantStatus> merchantMap = new LinkedHashMap<>();
        for (Merchant merchant : merchantMapper.selectMerchantList(m)){
            merchantMap.put(merchant,merchantStatusMapper.selectByPrimaryKey(merchant.getMerchantStatusId()));
        }
        return merchantMap;
    }

    @Override
    public int updateMerchantStatus(Merchant merchant) {
        if(merchant.getMerchantStatusId()==1)
            merchant.setMerchantStatusId(2);
        else
            merchant.setMerchantStatusId(1);
        return merchantMapper.updateMerchantStatus(merchant);
    }
}
