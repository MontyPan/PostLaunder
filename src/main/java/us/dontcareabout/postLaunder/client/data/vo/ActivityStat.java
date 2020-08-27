package us.dontcareabout.postLaunder.client.data.vo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sencha.gxt.core.client.util.DateWrapper;

public class ActivityStat {
	private final List<Activity> list;

	public ActivityStat(List<Activity> list) {
		this.list = list;

		Collections.sort(list, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.getDate().asDate().compareTo(o2.getDate().asDate());
			}
		});
	}

	public List<Activity> getList() {
		return list;
	}

	public DateWrapper getStartDate() {
		return list.get(0).getDate();
	}
}
