package internship.task.entity;

import java.time.Clock;
import java.time.ZoneId;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class TimeZoneEntity {
		
		private ZoneId myZone;		
		private Set<String> availZoneIds;
		private String selectedZoneId;
			
		public TimeZoneEntity() {
			this.myZone =  Clock.systemDefaultZone().getZone();
			this.availZoneIds = ZoneId.getAvailableZoneIds();
		}
		
		public ZoneId getMyZone() {
			return myZone;
		}
		public Set<String> getAvailZoneIds() {
			return availZoneIds;
		}
		
		public String getSelectedZoneId() {
			return selectedZoneId;
		}

		public void setSelectedZoneId(String selectedZoneId) {
			this.selectedZoneId = selectedZoneId;
		}

		public void setMyZone(ZoneId myZone) {
			this.myZone = myZone;
		}

		public void setAvailZoneIds(Set<String> availZoneIds) {
			this.availZoneIds = availZoneIds;
		}
}
