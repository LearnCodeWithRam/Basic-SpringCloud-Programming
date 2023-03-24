package com.tathagat.employeeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tathagat.Entity.Employee;
import com.tathagat.employeerepo.EmployeeRepo;
import com.tathagat.response.AddressResponse;
import com.tathagat.response.EmployeeResponse;

@Service
public class EmployeeService 
{

	
	@Autowired
	private EmployeeRepo emprepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	/*@Autowired
	private RestTemplate resttemplate;*/
	
	//private RestTemplate resttemplate;
	
	/** //$ indicate dynamic value of url
	@Value("${addressservice.base.url}")//getting uri from application.properties.
	private String addressBaseURL;
	
	
	public EmployeeService(RestTemplateBuilder builder) 
	{
		this.resttemplate= builder
				.build();	
	}
*/
	//constructor method to create dependency injection of rest template usinng resttemplate builder
	/**public EmployeeService(@Value("${addressservice.base.url}")String addressBaseURL,RestTemplateBuilder builder) 
	{
		this.resttemplate= builder
				.rootUri(addressBaseURL)
				.build();	
	}
*/
	@Autowired
	private WebClient webClient;
	public EmployeeResponse getEmpById(Integer id)
	{
		//AddressResponse adresp= new AddressResponse();
		Employee emp = emprepo.findById(id).get();//DB call
		
		/** //Manual mapping or automatic mapper,model mapper or any other mapper 
		EmployeeResponse empresp = new EmployeeResponse();
		empresp.setId(emp.getId());
		empresp.setName(emp.getName());
		empresp.setEmail(emp.getEmail());
		empresp.setBloodgroup(emp.getBloodgroup());*/
		
		//automatic mapping
		
		EmployeeResponse empresp = modelmapper.map(emp, EmployeeResponse.class);
		
		//AddressResponse adresp=resttemplate.getForObject("http://localhost:8282/address-app/api/Addresses/{id}", AddressResponse.class, id);
		//AddressResponse adresp=resttemplate.getForObject(addressBaseURL+"/Addresses/{id}", AddressResponse.class, id);
		//AddressResponse adresp=resttemplate.getForObject("/Addresses/{id}", AddressResponse.class, id);//DB call
        //restTemplate Blocking the thread /app until i get a response back from the address server
		AddressResponse adresp= webClient //nonblocking in nature
				.get()   //get request to url
				.uri("/Addresses/"+id)//set of uri
				.retrieve()//retrive data from this uri
				.bodyToMono(AddressResponse.class)//placing the data in addressres.
				.block();//get me back to address response
		empresp.setAddressresponse(adresp);
                return empresp;
		
	}
}
