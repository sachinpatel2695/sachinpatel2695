package com.assaabloy.counter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.assaabloy.counter.entity.Counter;

public interface CounterRepository  extends JpaRepository<Counter, Integer>{

}
