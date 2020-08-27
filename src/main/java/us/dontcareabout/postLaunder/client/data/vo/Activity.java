package us.dontcareabout.postLaunder.client.data.vo;

import com.sencha.gxt.core.client.util.DateWrapper;

import us.dontcareabout.gwt.client.google.SheetEntry;

public final class Activity extends SheetEntry {
	protected Activity() {}

	public String getId() {
		return stringField("id");
	}

	public DateWrapper getDate() {
		return new DateWrapper(dateField("日期"));
	}

	public Integer getAmount() {
		return intField("篇數");
	}
}
