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
	
	@PostMapping("/singup")
	public ResponseEntity<User> createEmployee(@RequestBody User user) {
		if(user.personType.equals(driver)){
			user.setId(data.increaseSize()); // increaseSize() return size than add +1 to size
			data.getDriver().add(new Driver(user));
			System.out.println("Name: " + user.getName());
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		}
		else if(user.personType.equals(passenger)) {
			data.getPassenger().add(new Passenger(user));
			System.out.println("Name: " + user.getName());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		//System.out.println("tmp: " + tmp);
}
	
	@GetMapping("/hatice")
	public int test() {
		return data.getDriver().size();
	}
	
	@PostMapping("/auth")
	public ResponseEntity<SuccessEntity> authentication(@RequestBody Auth auth) {
		int i=0;
		if(auth.getPersonType().contentEquals(driver)) {
			for(i=0;i < data.getSize(); i++) {
				if(data.getDriver().get(i).getMail().equals(auth.getMail()) 
						&& data.getDriver().get(i).getPassword().equals(auth.getPassword())) {
					SuccessEntity ent = new SuccessEntity(data.getDriver().get(i).getId(),true);
					return new ResponseEntity<>(ent, HttpStatus.OK);
						
				}
			}
			SuccessEntity ent = new SuccessEntity(-1,false);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		else if(auth.getPersonType().contentEquals(passenger)) {
			for(i=0;i < data.getSize(); i++) {
				if(data.getPassenger().get(i).getMail().equals(auth.getMail()) 
						&& data.getPassenger().get(i).getPassword().equals(auth.getPassword())) {
					SuccessEntity ent = new SuccessEntity(data.getPassenger().get(i).getId(),true);
					return new ResponseEntity<>(ent, HttpStatus.OK);
						
				}
			}
			SuccessEntity ent = new SuccessEntity(-1,false);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			System.out.println("Wrong anything");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
