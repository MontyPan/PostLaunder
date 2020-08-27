package us.dontcareabout.postLaunder.client.data;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

import us.dontcareabout.gwt.client.google.Sheet;
import us.dontcareabout.gwt.client.google.SheetHappen;
import us.dontcareabout.gwt.client.google.SheetHappen.Callback;
import us.dontcareabout.postLaunder.client.data.ActivityReadyEvent.ActivityReadyHandler;
import us.dontcareabout.postLaunder.client.data.vo.Activity;
import us.dontcareabout.postLaunder.client.data.vo.ActivityStat;

public class DataCenter {
	private final static SimpleEventBus eventBus = new SimpleEventBus();

	private static ActivityStat stat;

	public static ActivityStat getActivityStat() {
		return stat;
	}

	public static void wantActivity(String sheetId) {
		SheetHappen.get(sheetId, new Callback<Activity>() {
			@Override
			public void onSuccess(Sheet<Activity> gs) {
				stat = new ActivityStat(gs.getEntry());
				eventBus.fireEvent(new ActivityReadyEvent());
			}

			@Override
			public void onError(Throwable exception) {}
		});
	}

	public static HandlerRegistration addActivityReady(ActivityReadyHandler handler) {
		return eventBus.addHandler(ActivityReadyEvent.TYPE, handler);
	}
}
