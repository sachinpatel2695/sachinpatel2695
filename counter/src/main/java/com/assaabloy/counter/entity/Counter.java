package com.assaabloy.counter.entity;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Counter {

	@Id
	@GeneratedValue
    private int id;
	@Autowired
	AtomicInteger countValue;
	public Counter() {
		super();
		
	}
	public Counter(int id, AtomicInteger value) {
		super();
		this.id = id;
		this.countValue = value;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AtomicInteger getValue() {
		return countValue;
	}

	public void setValue(AtomicInteger value) {
		this.countValue = value;
	}
	
}
