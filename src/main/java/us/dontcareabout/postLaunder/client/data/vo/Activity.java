package us.dontcareabout.postLaunder.client.data.vo;

import java.util.Date;

import us.dontcareabout.gwt.client.google.SheetEntry;

public final class Activity extends SheetEntry {
	protected Activity() {}

	public String getId() {
		return stringField("id");
	}

	public Date getDate() {
		return dateField("日期");
	}

	public Integer getAmount() {
		return intField("篇數");
	}
}
