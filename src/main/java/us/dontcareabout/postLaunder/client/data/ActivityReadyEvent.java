package us.dontcareabout.postLaunder.client.data;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.postLaunder.client.data.ActivityReadyEvent.ActivityReadyHandler;

public class ActivityReadyEvent extends GwtEvent<ActivityReadyHandler> {
	public static final Type<ActivityReadyHandler> TYPE = new Type<ActivityReadyHandler>();

	@Override
	public Type<ActivityReadyHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ActivityReadyHandler handler) {
		handler.onActivityReady(this);
	}

	public interface ActivityReadyHandler extends EventHandler{
		public void onActivityReady(ActivityReadyEvent event);
	}
}
