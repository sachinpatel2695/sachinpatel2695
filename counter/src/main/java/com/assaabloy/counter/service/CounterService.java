package com.assaabloy.counter.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.assaabloy.counter.entity.Counter;

public interface CounterService {

	


public List<Counter> getAllData ();



 public Counter increase(int id);

 public Counter createCounter() ;
    
  public Counter getCount(int id) ;
}
