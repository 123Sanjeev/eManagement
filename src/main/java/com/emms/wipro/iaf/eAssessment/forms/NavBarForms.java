package com.emms.wipro.iaf.eAssessment.forms;

import org.json.JSONArray;
import org.json.JSONObject;

public class NavBarForms {

	private String menuName;
	private String menuUrl;
	private String type;
	private NavBarForms multiMenu;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public NavBarForms getMultiMenu() {
		return multiMenu;
	}

	public void setMultiMenu(NavBarForms multiMenu) {
		this.multiMenu = multiMenu;
	}

	@Override
	public String toString() {

		JSONObject navObject = new JSONObject();
		JSONArray menuArray = new JSONArray();

		if (this.type.equals("multi")) {
			JSONObject multiArrayObject = new JSONObject();
			multiArrayObject.put("MenuName", this.multiMenu.getMenuName());
			multiArrayObject.put("MenuUrl", this.multiMenu.getMenuUrl());
			multiArrayObject.put("type", this.multiMenu.getType());
			menuArray.put(multiArrayObject);
			navObject.put("mutiVal", menuArray);
		} else {
			navObject.put("MenuName", this.menuName);
			navObject.put("MenuUrl", this.menuUrl);
			navObject.put("type", this.type);
		}
		return navObject.toString();
	}

}
