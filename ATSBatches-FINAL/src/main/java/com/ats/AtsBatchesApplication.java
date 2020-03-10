package com.ats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ats.batch.BatchImpl;

@SpringBootApplication
public class AtsBatchesApplication implements CommandLineRunner{

	@Autowired
	private BatchImpl batch;
	
	public static void main(String[] args) {
		
		
	SpringApplication.run(AtsBatchesApplication.class, args);

	
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//BatchImpl batch=new BatchImpl();
		batch.preProcess();
		batch. start();
		batch.postProcess(); 
		
	}

}
