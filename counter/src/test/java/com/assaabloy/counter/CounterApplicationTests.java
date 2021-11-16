package com.assaabloy.counter;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assaabloy.counter.entity.Counter;
import com.assaabloy.counter.jpa.CounterRepository;
import com.assaabloy.counter.service.CounterServiceImpl;

@SpringBootTest
class CounterApplicationTests {

	
	@Autowired
	 CounterRepository repo;
	
	@Autowired
	CounterServiceImpl service;
   
	
	@Before
	public void Setup()
	{
 AtomicInteger newCount = new AtomicInteger(0);
		 
		 Counter counter= new Counter();
		  counter.setValue(newCount);
		 
		  repo.save(counter);
		  
	}
	@Test
	 public void createCounter() {
		
		  Assert.assertEquals(1, service.createCounter().getId());
	}
	
	
	@Test
	 public void increase() {
		
			  
			  Assert.assertEquals(1,service.increase(1).getValue().get());
	}
	
	
	    
	@Test
	  public void getCount() {
		
		  Assert.assertEquals(1, service.getCount(1).getValue().get());
		 
	}
	
	@Test
	public void getAllData (){
		 // check if it returns all records from DB
		List<Counter> count= service.getAllData(); 
	    assertTrue(count.size() > 0);
	    assertTrue(count.size()==1);
	}



	

}
