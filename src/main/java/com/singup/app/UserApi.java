package com.singup.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
	String driver = "driver", passenger = "passenger";
	Data data = new Data();
	@PostMapping("/berkan")
	public void createEmployee(@RequestBody String tmp) {
		/*if(user.personType.equals(driver)){
			data.getDriver().add(new Driver(user));
			System.out.println("Name: " + user.getName());
			//return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else if(user.personType.equals(passenger)) {
			data.getPassenger().add(new Passenger(user));
			System.out.println("Name: " + user.getName());
			//return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else {
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		*/
		System.out.println("tmp: " + tmp);
}
	
	@GetMapping("/hatice")
	public int test() {
		return data.getDriver().size();
	}
}
