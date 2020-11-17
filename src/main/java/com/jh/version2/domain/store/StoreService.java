package com.jh.version2.domain.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public StoreDto store1() {
        return StoreDto.of(storeRepository.findById(1L).get(), false);
    }

    public StoreDto store2() {
        return StoreDto.of(storeRepository.findById(1L).get(), true);
    }

    public List<StoreDto> stores1() {
        return StoreDto.list1(storeRepository.findAll());
    }

    public List<StoreDto> stores2() {
        return StoreDto.list2(storeRepository.findAll());
    }

}
