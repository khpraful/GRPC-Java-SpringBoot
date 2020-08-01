package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.grpc.EmployeeServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class GrpcEmpServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GrpcEmpServiceApplication.class, args);
		
Server server = ServerBuilder.forPort(9090).addService(new EmployeeServiceImpl()).build();
		
		server.start();
		
		System.out.println("Server started at: " + server.getPort());
		
		server.awaitTermination();
	}

}
