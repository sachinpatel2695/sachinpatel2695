package com.assaabloy.counter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assaabloy.counter.entity.Counter;
import com.assaabloy.counter.service.CounterServiceImpl;

@RestController
public class CountController {

	@Autowired
	CounterServiceImpl service;
	  @GetMapping("/counterIncrease/{id}")
	public Counter increase(@PathVariable int id)
	{
		//return new Limits(config.getMinimum(),config.getMaximum());
		System.out.println("Increase called");
		
		//int ids=Integer.parseInt(id);
		return service.increase(id);
	}
	
	@GetMapping("/getAllCounters")
	public List<Counter> getAllCounters()
	{
		System.out.println("getdata called");
		return service.getAllData();
		//return new Limits(config.getMinimum(),config.getMaximum());
	}
	
	@GetMapping("/createNewCounter")
	public Counter createNewCounter()
	{
	
		return service.createCounter();
		//return new Limits(config.getMinimum(),config.getMaximum());
	}
	
	@GetMapping("/getCount/{id}")
	public Counter getCount(@PathVariable int id)
	{
	
		return service.getCount(id);
		//return new Limits(config.getMinimum(),config.getMaximum());
	}
}
