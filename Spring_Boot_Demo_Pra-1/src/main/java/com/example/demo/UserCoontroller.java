package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v")
public class UserCoontroller {

	@Autowired
	private VRepo vRepo;
	
	@GetMapping
	public Page<Vehicle> getAll(@RequestParam int pageNO,@RequestParam int size){
		Pageable p = PageRequest.of(pageNO,size);
		
		return vRepo.findAll(p);
	}
	
	@GetMapping("/sort")
	public List<Vehicle> getBySort(@RequestParam String sortBy) {
		Sort p = Sort.by(sortBy);
		
		return vRepo.findAll(p);
	}
	
	
	@PostMapping
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return vRepo.save(vehicle);
	}
	
	@GetMapping("/{id}")
	public Optional<Vehicle> createVehicleById(@PathVariable Long id) {
		return vRepo.findById(id);
	}
	
	@PutMapping("/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle,@PathVariable Long id) throws Exception {
		Vehicle ve = vRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		ve.setBrand(vehicle.getBrand());
		ve.setModel(vehicle.getModel());
		ve.setYear(vehicle.getYear());
		return vRepo.save(ve);
	}
	
	@DeleteMapping("/{id}")
	public void delVehicle(@PathVariable Long id) {
		vRepo.deleteById(id);
	}
}
