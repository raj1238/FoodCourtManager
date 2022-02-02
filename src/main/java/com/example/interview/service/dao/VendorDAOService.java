package com.example.interview.service.dao;

import com.example.interview.models.Vendor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendorDAOService {

    private Map<Integer,Vendor> vendorMap = new HashMap<>();
    private static int vendorNo = 0;

    public void createNewVendor(String name){
        vendorNo++;
        Vendor vendor = new Vendor(vendorNo,name);
        vendorMap.put(vendorNo,vendor);
    }

    public List<Vendor> fetchAllVendors(){
        return (List<Vendor>) vendorMap.values();
    }

    public Vendor findVendorFromNumber(int no){
        for (Vendor value : vendorMap.values()) {
            if(value.getVendorNo()==no)
                return value;
        }
        return null;
    }
}
