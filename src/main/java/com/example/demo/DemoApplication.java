package com.example.demo;

import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private final CatRepository cr;
	
	@Autowired
	public DemoApplication(CatRepository cr) {
		super();
		this.cr = cr;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Stream.of("adhi", "barath").forEach(name -> {
			cr.save(new Cat(name));
		});		
	}
	
	
}

@Entity
class Cat{
	@Id
	@GeneratedValue
	private long id;
	private String name;
	public Cat() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cat(String name) {
		super();
		this.name = name;
	}
	
	
}