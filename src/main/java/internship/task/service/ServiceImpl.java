package internship.task.service;

import java.time.ZonedDateTime;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import internship.task.entity.TimeZoneEntity;

@Service
public class ServiceImpl {

		@Autowired
		private TimeZoneEntity tze;

		public ServiceImpl(TimeZoneEntity tze) {
			super();
			this.tze = tze;
		}

		public String getMyCountry() {
			// TODO Auto-generated method stub
			return tze.getMyZone().toString();
		}

		public ZonedDateTime getMyTime() {
			// TODO Auto-generated method stub
			return ZonedDateTime.now(tze.getMyZone());
		}

		public Set<String> getAllZones() {
			// TODO Auto-generated method stub
			return tze.getAvailZoneIds();
		}
}
