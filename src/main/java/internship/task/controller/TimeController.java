package internship.task.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import internship.task.entity.TimeZoneEntity;
import internship.task.service.ServiceImpl;

@Controller
public class TimeController {
		
		@Autowired
		private ServiceImpl serviceImpl;

		public TimeController(ServiceImpl serviceImpl) {
			super();
			this.serviceImpl = serviceImpl;
		}
		
		//Handler method returning model and view about time to be shown
		@GetMapping("/")
		public String viewHomePage(Model model) {
			
			model.addAttribute("workingTZ", new TimeZoneEntity() );
			return "start";
		}
			
		@GetMapping("/home")
		public String viewHomePage1(@ModelAttribute("workingTZ") TimeZoneEntity tzobj, Model model) {		
			
			model.addAttribute("mytime", serviceImpl.getMyTime());
			model.addAttribute("myCountry",serviceImpl.getMyCountry() );
			model.addAttribute("allZones", serviceImpl.getAllZones());
			return "page1";
		}	
		
		@PostMapping("/page2")
		public String submitForm(@ModelAttribute("workingTZ") TimeZoneEntity tzobj, Model model) {
			
		    ZoneId id = ZoneId.of(tzobj.getSelectedZoneId()); // ,ZoneId.SHORT_IDS);
		    ZonedDateTime newtime = ZonedDateTime.now(id);
		    
		    model.addAttribute("mytime", ZonedDateTime.now(tzobj.getMyZone()));
			model.addAttribute("myCountry",tzobj.getMyZone().toString() );
			model.addAttribute("allZones", tzobj.getAvailZoneIds());
		    
		    model.addAttribute("selectedZone", tzobj.getSelectedZoneId());	   
			model.addAttribute("newzoneTime", newtime);
		
		    return "page2";		
		}

}
