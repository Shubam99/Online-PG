package sss.pgs.model;

import java.io.Serializable;

public class PGDetailsInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String PGName;
	private String PGState;
	private String PGDistrict;
	private String PGLocation;
	private String PGLandmark;
	private String PGAddress;
	private int PGDisPin;
	private String PGType;
	private String PGTypac;
	private int PGCost;
	private int PGCapacity;
	private String OwnerEmail;
	public PGDetailsInfo()
	{
		
	}

	public String getPGName() {
		return PGName;
	}
	public void setPGName(String pGName) {
		PGName = pGName;
	}
	public String getPGState() {
		return PGState;
	}
	public void setPGState(String pGState) {
		PGState = pGState;
	}
	public String getPGDistrict() {
		return PGDistrict;
	}
	public void setPGDistrict(String pGDistrict) {
		PGDistrict = pGDistrict;
	}
	public String getPGLocation() {
		return PGLocation;
	}
	public void setPGLocation(String pGLocation) {
		PGLocation = pGLocation;
	}
	public String getPGLandmark() {
		return PGLandmark;
	}
	public void setPGLandmark(String pGLandmark) {
		PGLandmark = pGLandmark;
	}
	public String getPGAddress() {
		return PGAddress;
	}
	public void setPGAddress(String pGAddress) {
		PGAddress = pGAddress;
	}
	public int getPGDisPin() {
		return PGDisPin;
	}
	public void setPGDisPin(int pGDisPin) {
		PGDisPin = pGDisPin;
	}
	
	public String getPGType() {
		return PGType;
	}
	public void setPGType(String pGType) {
		PGType = pGType;
	}
	public String getPGTypac() {
		return PGTypac;
	}
	public void setPGTypac(String pGTypac) {
		PGTypac = pGTypac;
	}
	public int getPGCost() {
		return PGCost;
	}
	public void setPGCost(int pGCost) {
		PGCost = pGCost;
	}
	public int getPGCapacity() {
		return PGCapacity;
	}
	public void setPGCapacity(int pGCapacity) {
		PGCapacity = pGCapacity;
	}
	public String getOwnerEmail() {
		return OwnerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		OwnerEmail = ownerEmail;
	}
	
	
	}
