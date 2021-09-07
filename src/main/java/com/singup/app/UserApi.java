package com.singup.app;

import java.util.ArrayList;

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
			user.setId(data.increaseSize()); // increaseSize() return size than add +1 to size
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
			return new ResponseEntity<>(ent, HttpStatus.OK);
			
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
			return new ResponseEntity<>(ent, HttpStatus.OK);
		}
		else {
			System.out.println("Wrong anything");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@PostMapping("/addbus")
	public Integer busResponse(@RequestBody Bus bus ) {
		int busId = data.addAndReturnBusId();
		bus.setBusDriverId(busId);
		bus.setBusId(String.valueOf(busId));
		data.getBus().add(bus);
		System.out.println("BusId: " + String.valueOf(busId));
		return busId;
	}
	@PostMapping("/joinbus")
	public String Joinbus(@RequestBody JoinBus joinbus) {
		int i =0 ,busNum =0;
		Boolean flag = false;
		System.out.println("istek geldi: "+ data.getBus().size());
		for(i=0;i<data.getBus().size();i++) {
			if(data.getBus().get(i).getBusId().equals(joinbus.getBusId()) ) {
				busNum = i;
				flag = true;
				break;
			}
		}
		if(flag == true) {
			for(i=0; i < data.getBus().get(busNum).getBusPassenger().size(); i++) {
				if(data.getBus().get(busNum).getBusPassenger().get(i).getId()==Integer.valueOf(joinbus.getPassengerId())) {
					System.out.println("already");
					return "already enroll bus";
				}
			}
			data.getBus().get(busNum).getBusPassenger()
				.add(data.getPassenger() 
						.get(Integer.valueOf(joinbus.getPassengerId()))); // add passenger to bus
			
			data.getPassenger().get(Integer.valueOf(joinbus.getPassengerId()))
				.getBusId().add(joinbus.getBusId());  // add bus to passenger
			System.out.println("istek dogru kayit yapildi");
			return "true";
		}
		else {
			System.out.println("flag false");
			return "false";
		}
		
		
	}
	@PostMapping("/allpassenger")
	public ResponseEntity<ArrayList<User>> pushAllPassenger(@RequestBody DriverId driverId){
		int i=0;
		System.out.println("driverId" + driverId.getDriverId());
		String busId =null;
		ArrayList<User> userList = new ArrayList<User>();
		for(i=0;i < data.getDriver().size();i++) {
			if(data.getDriver().get(i).getId()== Integer.valueOf(driverId.getDriverId())) {
				busId = data.getDriver().get(i).getBusId().get(0);
				break;
			}
		}
		int busIntId = Integer.valueOf(busId) -1000;
		for(i=0; i < data.getBus().size();i++) {
			userList.add(data.getBus().get(busIntId).getBusPassenger().get(i));
		}
		System.out.println("driverId: " +driverId );
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
}
