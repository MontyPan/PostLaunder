package us.dontcareabout.postLaunder.client.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

import us.dontcareabout.gwt.client.google.Sheet;
import us.dontcareabout.gwt.client.google.SheetHappen;
import us.dontcareabout.gwt.client.google.SheetHappen.Callback;
import us.dontcareabout.postLaunder.client.data.ActivityReadyEvent.ActivityReadyHandler;
import us.dontcareabout.postLaunder.client.data.vo.Activity;

public class DataCenter {
	private final static SimpleEventBus eventBus = new SimpleEventBus();

	private static ArrayList<Activity> activityList;

	public static List<Activity> getActivity() {
		return Collections.unmodifiableList(activityList);
	}

	public static void wantActivity(String sheetId) {
		activityList = new ArrayList<>();
		SheetHappen.get(sheetId, new Callback<Activity>() {
			@Override
			public void onSuccess(Sheet<Activity> gs) {
				activityList = gs.getEntry();
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
