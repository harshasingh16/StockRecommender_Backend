package com.abhinendra.domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TopFive implements  Comparator<TopFive>  {
	private String datacode;
    private int gains;

    
   public TopFive(){
    	gains=0;
    	datacode=" ";
    }
    

    public TopFive(int gains, String datacode) {
         this.gains = gains;
         this.datacode = datacode;
         
    }

    public String getDatacode() {
         return datacode;
    }
   
    public int getGains() {
	return gains;
    }
   
    public int calcGain(float open,float last) {
		float gain=((last-open)/open)*100;
		int gains=(int)gain;
		return gains;
	}
    @Override
    public int compare(TopFive o1, TopFive o2) {
        return o1.getGains() - o2.getGains();
    }
    public void printTopFive() {
    
    }
}
	
    /*class TopFiveComparatorByGains implements Comparator<TopFive> {
        @Override
        public int compare(TopFive o1, TopFive o2) {
            return o1.getGains() - o2.getGains();
        }
        public void PrintTopFive() {
        Collections.sort(list, new TopFiveComparatorByGains());
        System.out.println(list);
    }
    }*/
    
	


	

	

	
