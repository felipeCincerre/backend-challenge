package com.invillia.acme.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.store.model.Store;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = StoreRepository.class)
public class Application {

	@Autowired
	private StoreRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(){
		return args -> {
 
			System.out.print("<<<<<<<<<<<<<Cleaning MongoDatabase>>>>>>>>>>>>>>");
			repository.deleteAll();
 
			for(int i=0;i<5;i++){
				Store store = repository.save(new Store("Invillia Store "+i, "Rua Padre Duarte, 1253"));
 
				System.out.println("<<<<<<<<<<<<<Adding Store >>>>>>>>>>>>>>");
				System.out.println("***"+store.toString()+"***");
			}
 
			System.out.println("<<<<<<<<<<<<<Get All Stores >>>>>>>>>>>>>>");
			List<Store> storeList=repository.findAll();
			storeList.forEach(item -> System.out.println(item));
 
			storeList.clear();
 
			System.out.println("<<<<<<<<<<<<<Find Store By Name >>>>>>>>>>>>>>");
		    storeList=repository.findByName("Invillia Store 0");
			storeList.forEach(item -> System.out.println(item));
 
			System.out.println("<<<<<<<<<<<<<Updating Invillia Store 0 >>>>>>>>>>>>>>");
		    storeList=repository.findByName("Invillia Store 0");
		    for (Store store : storeList) {
				store.setName("Nova Invillia Store");
				repository.save(store);
				System.out.println("***"+store.toString()+"***");
			}
			
			System.out.println("Executed");
 
		};
	}
}

