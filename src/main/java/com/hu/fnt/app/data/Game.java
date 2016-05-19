package com.hu.fnt.app.data;

public class Game {
	private int appId;
	private String title;
	private String description;
	private String[] supportedLanguages;
	private String website;
	private String[] pcRequirements;
	private String headerImage;
	private String[] developers;
	private double price;
	
	private double ignRating;
	private String giantBombReview;
	private String videoId;
	
	public Game(int appId, String title){
		this.appId = appId;
		this.title = title;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getSupportedLanguages() {
		return supportedLanguages;
	}

	public void setSupportedLanguages(String[] supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String[] getPcRequirements() {
		return pcRequirements;
	}

	public void setPcRequirements(String[] pcRequirements) {
		this.pcRequirements = pcRequirements;
	}

	public String getHeaderImage() {
		return headerImage;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public String[] getDevelopers() {
		return developers;
	}

	public void setDevelopers(String[] developers) {
		this.developers = developers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getIgnRating() {
		return ignRating;
	}

	public void setIgnRating(double ignRating) {
		this.ignRating = ignRating;
	}

	public String getGiantBombReview() {
		return giantBombReview;
	}

	public void setGiantBombReview(String giantBombReview) {
		this.giantBombReview = giantBombReview;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	
}
