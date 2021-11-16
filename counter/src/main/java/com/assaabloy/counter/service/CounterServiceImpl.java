package com.assaabloy.counter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assaabloy.counter.entity.Counter;
import com.assaabloy.counter.jpa.CounterRepository;


@Service
public class CounterServiceImpl implements CounterService{

	 @Autowired
	 CounterRepository repo;
    
  
@Override
public List<Counter> getAllData ()
{
	return repo.findAll();
}

@Override
 public Counter increase(int id) {

	   Counter counter= repo.findById(id).get();
  
	counter.getValue().incrementAndGet();

	 return repo.save(counter);
 }

@Override
 public Counter createCounter() {
	 AtomicInteger newCount = new AtomicInteger(0);
	 
	 Counter counter= new Counter();
	  counter.setValue(newCount);
	  System.out.println(counter.getValue()+"   "+counter.getId());
	return  repo.save(counter);
	  }
    
@Override
  public Counter getCount(int id) {
    return repo.findById(id).get();
  }
}
