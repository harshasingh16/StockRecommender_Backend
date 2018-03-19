package com.abhinendra;

import com.abhinendra.services.CompanyDetailLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.convert.Jsr310Converters;
import com.abhinendra.domain.TopFive;
import com.abhinendra.domain.TopFiveDisplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = { "com.abhinendra.domain" })
@ComponentScan(basePackages = "com.abhinendra")
public class ServerApplication {
	@Autowired
	CompanyDetailLoader companyDetailLoader;
	ArrayList<TopFiveDisplay> listFinal = new ArrayList<TopFiveDisplay>();
	ArrayList<TopFiveDisplay> listFinal1 = new ArrayList<TopFiveDisplay>();
	ArrayList<TopFiveDisplay> listFinal2 = new ArrayList<TopFiveDisplay>();
	ArrayList<TopFiveDisplay> listFinal3 = new ArrayList<TopFiveDisplay>();
	ArrayList<TopFiveDisplay> listFinal4 = new ArrayList<TopFiveDisplay>();
//	ArrayList<Integer> change=new ArrayList<Integer>();


//	@PostConstruct
//	public void loadDetails() {
//		String[] FoodSector = { "ADFFOODS", "DFMFOODS", "ATFL", "DAAWAT", "HERITGFOOD", "KOHINOOR", "LAKSHMIEFL" };
//		String[] Mills = { "PHOENIXLTD", "APOLLO", "AMJLAND", "RAMGOPOLY", "ASTRON", "SHIVATEX" };
//		String[] Software = { "SONATSOFTW", "TERASOFT", "CALSOFT", "COMPUSOFT", "CYBERTECH", "NEWGEN", "FCSSOFT" };
//		String[] Bank = { "BANKBARODA", "BANKINDIA", "DENABANK", "SYNDIBANK", "CORPBANK", "UCOBANK", "VIJAYABANK",
//				"ANDHRABANK" };
//		String[] Energy = { "INDOWIND", "KARMAENG", "XLENERGY", "UJAAS", "JSWENERGY", "SUZLON", "SWANENERGY",
//				"BGRENERGY" };
//		ArrayList<TopFive> list = new ArrayList<TopFive>();
//
//		System.out.println("FoodSector:");
//
//		for (int i = 0; i < FoodSector.length; i++) {
//			TopFive top = companyDetailLoader.loadDetails(FoodSector[i]);
//
//			list.add(top);
//
//		}
//
//
//		Collections.sort(list,  new Comparator<TopFive>(){
//			public int compare(TopFive o1, TopFive o2){
//				return o1.getGains() - o2.getGains());
//			}
//		});
//	//	System.out.println("After:" + list.size());
//
//		for (int i = list.size()-1; i>list.size()-6; i--) {
//
//	//		System.out.print(list.get(i).getDatacode()+ "    ");
//	//		System.out.println(list.get(i).getGains());
//			TopFiveDisplay topd=companyDetailLoader.loadDetailsDaily(list.get(i).getDatacode(),list.get(i).getGains());
//			listFinal.add(topd);
//
//		}
//		System.out.println(listFinal.size());
//		System.out.println(listFinal);
//
//		ArrayList<TopFive> list1 = new ArrayList<TopFive>();
//
//		System.out.println("Mills:");
//
//		for (int i = 0; i < Mills.length; i++) {
//			TopFive top1 = companyDetailLoader.loadDetails(Mills[i]);
//
//			list1.add(top1);
//
//		}
//
//
//
//		Collections.sort(list1, new TopFive());
//
//
//		for (int i = list1.size()-1; i>list1.size()-6; i--) {
//		//	System.out.print(list1.get(i).getDatacode()+ "    ");
//		//	System.out.println(list1.get(i).getGains());
//			TopFiveDisplay topd1=companyDetailLoader.loadDetailsDaily(list1.get(i).getDatacode(),list1.get(i).getGains());
//			listFinal1.add(topd1);
//		}
//		System.out.println(listFinal1.size());
//		System.out.println(listFinal1);
//
//		ArrayList<TopFive> list2 = new ArrayList<TopFive>();
//
//		System.out.println("Software:");
//
//		for (int i = 0; i < Software.length; i++) {
//			TopFive top2 = companyDetailLoader.loadDetails(Software[i]);
//
//			list2.add(top2);
//
//		}
//
//
//		Collections.sort(list2, new TopFive());
//
//		for (int i = list2.size()-1; i>list2.size()-6; i--) {
//		//	System.out.print(list2.get(i).getDatacode()+ "    ");
//		//	System.out.println(list2.get(i).getGains());
//			TopFiveDisplay topd2=companyDetailLoader.loadDetailsDaily(list2.get(i).getDatacode(),list2.get(i).getGains());
//			listFinal2.add(topd2);
//		}
//		System.out.println(listFinal2.size());
//		System.out.println(listFinal2);
//
//
//		ArrayList<TopFive> list3 = new ArrayList<TopFive>();
//
//		System.out.println("Bank:");
//
//		for (int i = 0; i < Bank.length; i++) {
//			TopFive top3 = companyDetailLoader.loadDetails(Bank[i]);
//
//			list3.add(top3);
//
//		}
//
//
//
//		Collections.sort(list3, new TopFive());
//
//		for (int i = list3.size()-1; i>list3.size()-6; i--) {
//		//	System.out.print(list3.get(i).getDatacode()+ "    ");
//		//	System.out.println(list3.get(i).getGains());
//			TopFiveDisplay topd3=companyDetailLoader.loadDetailsDaily(list3.get(i).getDatacode(),list3.get(i).getGains());
//			listFinal3.add(topd3);
//		}
//		System.out.println(listFinal3.size());
//		System.out.println(listFinal3);
//
//		ArrayList<TopFive> list4 = new ArrayList<TopFive>();
//
//		System.out.println("Energy:");
//
//		for (int i = 0; i < Energy.length; i++) {
//			TopFive top4 = companyDetailLoader.loadDetails(Energy[i]);
//
//			list4.add(top4);
//
//		}
//
//
//		Collections.sort(list4, new TopFive());
//
//		for (int i = list4.size()-1; i>list4.size()-6; i--) {
//		//	System.out.print(list4.get(i).getDatacode()+ "    ");
//		//	System.out.println(list4.get(i).getGains());
//			TopFiveDisplay topd4=companyDetailLoader.loadDetailsDaily(list4.get(i).getDatacode(),list4.get(i).getGains());
//			listFinal4.add(topd4);
//		}
//		System.out.println(listFinal4.size());
//		System.out.println(listFinal4);
//
//
//
//
//
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);

	}
}
