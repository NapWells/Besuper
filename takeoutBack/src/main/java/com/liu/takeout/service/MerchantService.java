package com.liu.takeout.service;

import com.liu.takeout.entity.Merchant;
import com.liu.takeout.entity.MerchantStatus;

import java.util.Map;

/**
 * Created by anybody on 2016/12/13.
 */
public interface MerchantService {
    Map<Merchant,MerchantStatus> getMerchant(String serach);
    int updateMerchantStatus(Merchant merchant);
}
