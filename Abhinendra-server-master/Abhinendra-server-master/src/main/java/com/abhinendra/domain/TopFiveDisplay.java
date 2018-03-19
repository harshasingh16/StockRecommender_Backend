package com.abhinendra.domain;

public class TopFiveDisplay {
//	private int id;
	private String data_code;
	private float open;
	private float high;
	private float low;
	private float last;
	private float close;
	private float tot_trade;
	private float turnover;

	
	public TopFiveDisplay() {
	//	id=0;
		data_code=" ";
		 open=0;
		 high=0;
		 low=0;
		 last=0;
		 close=0;
		 tot_trade=0;
		 turnover=0;
		
	}
	public TopFiveDisplay(String data_code,float open,float high,float low,float last,float close,float tot_trade,float turnover) {
	//	this.id=id;
		this.data_code=data_code;
		 this.open=open;
		 this.high=high;
		 this.low=low;
		 this.last=last;
		 this.close=close;
		 this.tot_trade=tot_trade;
		 this.turnover=turnover;
		
	}
	/*public int getId()
	{
		return id;
	}*/
	public String getData_code() {
		return data_code;
	}
	public float getOpen() {
		return open;
	}
	public float getHigh() {
		return high;
	}
	public float getLow() {
		return low;
	}
	public float getLast() {
		return last;
	}
	public float getClose() {
		return close;
	}
	public float getTottrade() {
		return tot_trade;
	}
	public float getTurnover() {
		return turnover;
	}
	@Override
	   public String toString() {
	        return ("DataCode:"+this.getData_code()+
	                    " Open: "+ this.getOpen() +
	                    " High: "+ this.getHigh() +
	                    " Last : " + this.getLast()+
	                    "Close:"+this.getClose()+
	                    "TotalTrade:"+this.getTottrade()+
	                    "Turnover:"+this.getTurnover());
	   }

}
