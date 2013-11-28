package com.tide.common;

import java.io.Serializable;

public class Tide implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstSpringTide;
	private String firstNeapTide;
	private String firstPeaceTide;
	private String secondSpringTide;
	private String secondNeapTide;
	private String secondPeaceTide;
	private LunarEnum lunarDate;	
	public Tide(
			LunarEnum lunarDate,
			String firstSpringTide,
			String firstNeapTide,
			//String firstPeaceTide,
			String secondSpringTide,
			String secondNeapTide
			//String secondPeaceTide
			){
		this.lunarDate = lunarDate;
		this.firstSpringTide = firstSpringTide;
		this.firstNeapTide = firstNeapTide;
		//this.firstPeaceTide = firstPeaceTide;
		this.secondSpringTide = secondSpringTide;
		this.secondNeapTide = secondNeapTide;
		//this.secondPeaceTide = secondPeaceTide;
		
	}
	/**
	 * 
	 * @return
	 */
	public String getFirstSpringTide(){
		return firstSpringTide;
	}
	public void setFirstSpringTide(String firstSpringTide){
		this.firstSpringTide = firstSpringTide;
	}
	/**
	 * 
	 * @return
	 */
	public String getFirstNeapTide(){
		return firstNeapTide;
	}
	public void setFirstNeapTide(String firstNeapTide){
		this.firstNeapTide = firstNeapTide;
	}
	/**
	 * 
	 * @return
	 */
	public String getFirstPeaceTide(){
		return firstPeaceTide;
	}
	public void setFirstPeaceTide(String firstPeaceTide){
		this.firstPeaceTide = firstPeaceTide;
	}
	/**
	 * 
	 * @return
	 */
	public String getSecondSpringTide(){
		return secondSpringTide;
	}
	public void setSecondSpringTide(String secondSpringTide){
		this.secondSpringTide = secondSpringTide;
	}
	/**
	 * 
	 * @return
	 */
	public String getSecondNeapTide(){
		return secondNeapTide;
	}
	public void setSecondNeapTide(String secondNeapTide){
		this.secondNeapTide = secondNeapTide;
	}
	/**
	 * 
	 * @return
	 */
	public String getSecondPeaceTide(){
		return secondPeaceTide;
	}
	public void setSecondPeaceTide(String secondPeaceTide){
		this.secondPeaceTide = secondPeaceTide;
	}
	/**
	 * 
	 * @return
	 */
	public LunarEnum getLunarDate(){
		return lunarDate;
	}
	public void setLunarDate(LunarEnum lunarDate){
		this.lunarDate = lunarDate;
	}
}
