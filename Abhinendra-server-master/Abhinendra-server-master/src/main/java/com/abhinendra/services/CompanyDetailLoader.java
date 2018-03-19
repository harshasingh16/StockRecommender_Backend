package com.abhinendra.services;

import com.abhinendra.domain.CompanyDetails;
import com.abhinendra.domain.TopFive;
import com.abhinendra.domain.TopFiveDisplay;

public interface CompanyDetailLoader {
    public TopFive loadDetails(String companyTicker) ;

	public TopFiveDisplay loadDetailsDaily(String companyTicker,int gain);
}
