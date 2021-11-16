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
   
	
	@Before
	public void Setup()
	{
 AtomicInteger newCount = new AtomicInteger(0);
		 
		 Counter counter= new Counter();
		  counter.setValue(newCount);
		  System.out.println(counter.getValue()+"   "+counter.getId());
		  repo.save(counter);
		  
	}
	@Test
	 public void createCounter() {
		 AtomicInteger newCount = new AtomicInteger(0);
		 
		 Counter counter= new Counter();
		  counter.setValue(newCount);
		  System.out.println(counter.getValue()+"   "+counter.getId());
		  
		  Assert.assertEquals(1, repo.save(counter).getId());
	}
	
	
	@Test
	 public void increase() {
		  Counter counter= repo.findById(1).get();
		  
			counter.getValue().incrementAndGet();

			  repo.save(counter);
			  
			  Assert.assertEquals(1, repo.save(counter).getValue().get());
	}
	
	
	    
	@Test
	  public void getCount() {
		
		  Assert.assertEquals(1,  repo.findById(1).get().getValue().get());
		 
	}
	
	@Test
	public void getAllData (){
		 // check if it returns all records from DB
		List<Counter> count= repo.findAll(); 
	    assertTrue(count.size() > 0);
	    assertTrue(count.size()==1);
	}



	

}
