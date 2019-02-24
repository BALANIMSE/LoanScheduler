# Brief about the problem statement 
	1. To generate the loan repayment schedule in preferred formats like JSON, CSV etc.

# Brief about the solution
	1. Developed spring-boot RESTful service which accept the JSON request and respond with JSON and CSV format data.
	2. Key features of solution are 
		a. spring-boot web application 
		b. True REpresentational  Style Transfer implementation. Where single REST API has capability to respond in JSON and CSV format.
		c. Various design patterns and principals like singletone, factory, Front controller, Adapter and SOLID
			
  
   
# LoanScheduler Deployment and Execution 

a. Pre-requisite 
	1. Git Client installed
	2. Maven installed
	3. JDK 1.8 and above installed
	4. Postman client

b. Deployment Steps
	1. Git checkout of this project

c. Execution Steps  : 
   Run following commands sequentially at the checked out directory of the project
	1. mvn install
	2. mvn spring-boot:run

d. Verification of Result: Use POSTMAN to verify the RESTful service result.
   On completion of step #c, application will be up and running. One can verify the result as below. 
	1. Verify JSON response : 
		a. URL : http://localhost:8080/loan/generate-plan
		b. Method : POST 
		c. Request Payload : 
			{
				"loanAmount": 5000.00,
				"nominalRate":5.00,
				"duration":24,
				"startDate":"2018-01-01"
			}
		d. Request 'Content-Type=application/json'
		e. Fire request
	2. Verify CSV response
		a. URL : http://localhost:8080/loan/generate-plan?mediatype=application/csv
		b. Method : POST 
		c. Request Payload : 
			{
				"loanAmount": 5000.00,
				"nominalRate":5.00,
				"duration":24,
				"startDate":"2018-01-01"
			}
		d. Request 'Content-Type=application/json'
		e. Fire request
