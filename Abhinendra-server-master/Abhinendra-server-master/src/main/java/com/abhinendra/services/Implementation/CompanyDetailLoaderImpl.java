package com.abhinendra.services.Implementation;

import com.abhinendra.domain.CompanyDetails;
import com.abhinendra.domain.Dataset;
import com.abhinendra.domain.TopFive;
import com.abhinendra.domain.TopFiveDisplay;
import com.abhinendra.services.CompanyDetailLoader;
import org.springframework.stereotype.Service;

import static com.jayway.restassured.RestAssured.given;
@Service
public class CompanyDetailLoaderImpl  implements CompanyDetailLoader{
      

    String urlPart1="https://www.quandl.com/api/v3/datasets/NSE/";
    String urlPart2= ".json?api_key=VYpxRfPNGWfpxovPnEYT&collapse=weekly&start_date=2018-03-06";
    String urlPart3=".json?api_key=VYpxRfPNGWfpxovPnEYT&collapse=daily&start_date=2018-03-16";
    int i=0;
    @Override
    public TopFive loadDetails(String companyTicker) {
        CompanyDetails companyDetails=given().when().get(urlPart1+companyTicker+urlPart2).as(CompanyDetails.class);
      Dataset dat=companyDetails.getDataset();
      
  //    System.out.println("Printing data: "+dat.getData().toString());
  //    System.out.println("Printing open: "+dat.getData().get(0).get(1).toString());
float open=Float.parseFloat(dat.getData().get(1).get(1));
//System.out.println(open);
float last=Float.parseFloat(dat.getData().get(0).get(4));
String datacode=dat.getDatasetCode();
  //      System.out.println("Printing details "+companyDetails.getDataset().toString());
TopFive tp=new TopFive();

int gain=tp.calcGain(open,last);
TopFive t=new TopFive(gain,datacode);





        return t;
    }
    @Override
    public TopFiveDisplay loadDetailsDaily(String companyTicker, int gain) {
        CompanyDetails companyDetails=given().when().get(urlPart1+companyTicker+urlPart3).as(CompanyDetails.class);
        Dataset dat=companyDetails.getDataset();
        
    //    System.out.println("Printing data: "+dat.getData().toString());
    //    System.out.println("Printing open: "+dat.getData().get(0).get(1).toString());
        
    //    int id=++i;
  //System.out.println(open);
  float open=Float.parseFloat(dat.getData().get(0).get(1));
  float high=Float.parseFloat(dat.getData().get(0).get(2));
  float low=Float.parseFloat(dat.getData().get(0).get(3));
  float last=Float.parseFloat(dat.getData().get(0).get(4));
  float close=Float.parseFloat(dat.getData().get(0).get(5));
  float tot_trade=Float.parseFloat(dat.getData().get(0).get(6));
  float turnover=Float.parseFloat(dat.getData().get(0).get(7));
  String datacode=dat.getDatasetCode();
  int change=gain;
    //      System.out.println("Printing details "+companyDetails.getDataset().toString());
  

  
  TopFiveDisplay td=new TopFiveDisplay(datacode, open, high, low, last, close, tot_trade, turnover);

return td;
    }
  /*  @Override
   public CompanyDetails loadDetailsWithout() {
        CompanyDetails companyDetails=given().when().get("https://www.quandl.com/api/v3/datasets/NSE/TCS.json?api_key=VYpxRfPNGWfpxovPnEYT&collapse=weekly&start_date=2018-03-06").as(CompanyDetails.class);
             System.out.println("Printing details "+companyDetails.getDataset().toString());

    	return companyDetails;
    }*/
}
