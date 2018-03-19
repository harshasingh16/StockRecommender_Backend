package com.abhinendra.controllers;

import com.abhinendra.domain.TopFive;
import com.abhinendra.services.CompanyDetailLoader;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Api(tags = "/topFive", description = "Top five Companies based on sector")
@RequestMapping("/topFive")
public class TopFiveCompaniesController {
    @Autowired
    CompanyDetailLoader companyDetailLoader;

    @GetMapping(value = "/{sectorName}", produces = "application/json")
    List<TopFive> getTopFiveCompaniesOfSector(@PathVariable("sectorName") String sectorName) {
        String[] Food = {"ADFFOODS", "DFMFOODS", "ATFL", "DAAWAT", "HERITGFOOD", "KOHINOOR", "LAKSHMIEFL"};
        String[] Mill = {"PHOENIXLTD", "APOLLO", "AMJLAND", "RAMGOPOLY", "ASTRON", "SHIVATEX"};
        String[] Software = {"SONATSOFTW", "TERASOFT", "CALSOFT", "COMPUSOFT", "CYBERTECH", "NEWGEN", "FCSSOFT"};
        String[] Bank = {"BANKBARODA", "BANKINDIA", "DENABANK", "SYNDIBANK", "CORPBANK", "UCOBANK", "VIJAYABANK",
                "ANDHRABANK"};
        String[] Energy = {"INDOWIND", "KARMAENG", "XLENERGY", "UJAAS", "JSWENERGY", "SUZLON", "SWANENERGY",
                "BGRENERGY"};
        HashMap<String,String[]> sectorListMap=new HashMap<>();
        sectorListMap.put("Food",Food);
        sectorListMap.put("Mill",Mill);
        sectorListMap.put("Software",Software);
        sectorListMap.put("Bank",Bank);
        sectorListMap.put("Energy",Energy);

        String[ ] sector=sectorListMap.get(sectorName);

        ArrayList<TopFive> list = new ArrayList<TopFive>();
        for (int i = 0; i < sector.length; i++) {
            TopFive top = companyDetailLoader.loadDetails(sector[i]);
            list.add(top);
        }
        Collections.sort(list, new Comparator<TopFive>() {
            public int compare(TopFive o1, TopFive o2) {
                return o2.getGains() - o1.getGains();
            }
        });
        return list.subList(0, 5);
    }


}
