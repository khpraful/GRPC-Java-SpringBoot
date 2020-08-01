package com.example.demo.grpc;

import com.emp.grpc.EmployeeOuterClass.Employee;
import com.emp.grpc.EmployeeOuterClass.EmployeeResponse;
import com.emp.grpc.EmployeeServiceGrpc.EmployeeServiceImplBase;
import io.grpc.stub.StreamObserver;

public class EmployeeServiceImpl extends EmployeeServiceImplBase{

	@Override
	public void getEmployee(Employee request, StreamObserver<EmployeeResponse> responseObserver) {
		
		System.out.println("Inside employee service");
		
		int empId = request.getEmpID();
		String empName = request.getEmpName();
		String empDept = request.getEmpDept();
		
		String message = empId + " : " + empName + " : " + empDept;
		

		EmployeeResponse.Builder response = EmployeeResponse.newBuilder();

		response.setMessage(message);

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}
	
	

}
