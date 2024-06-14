package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/u")
public class VehiCOntoller {

	@Autowired
	private URepo vRepo;
	
	@GetMapping
	public Page<User> getAll(@RequestParam int pageNO,@RequestParam int size){
		Pageable p = PageRequest.of(pageNO,size);
		
		return vRepo.findAll(p);
	}
	
	@GetMapping("/sort")
	public List<User> getBySort(@RequestParam String sortBy) {
		Sort p = Sort.by(sortBy);
		
		return vRepo.findAll(p);
	}
	
	
	@PostMapping
	public User createVehicle(@RequestBody User vehicle) {
		return vRepo.save(vehicle);
	}
	
	@GetMapping("/{id}")
	public Optional<User> createVehicleById(@PathVariable Long id) {
		return vRepo.findById(id);
	}
	
	@PutMapping("/{id}")
	public User updateVehicle(@RequestBody User vehicle,@PathVariable Long id) throws Exception {
		User ve = vRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		ve.setFname(vehicle.getFname());
		ve.setLname(vehicle.getLname());
		return vRepo.save(ve);
	}
	
	@DeleteMapping("/{id}")
	public void delVehicle(@PathVariable Long id) {
		vRepo.deleteById(id);
	}
}
