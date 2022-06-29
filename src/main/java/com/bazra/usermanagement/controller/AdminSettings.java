package com.bazra.usermanagement.controller;

import java.util.List;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bazra.usermanagement.model.AgentInfo;
import com.bazra.usermanagement.model.MerchantInfo;
import com.bazra.usermanagement.model.UserInfo;
import com.bazra.usermanagement.repository.AgentRepository;
import com.bazra.usermanagement.repository.MerchantRepository;
import com.bazra.usermanagement.repository.UserRepository;
import com.bazra.usermanagement.request.CreateSettingRequest;
import com.bazra.usermanagement.request.SettingRequest;
import com.bazra.usermanagement.response.TotalResponseAgents;
import com.bazra.usermanagement.response.TotalResponseCustomers;
import com.bazra.usermanagement.response.TotalResponseMerchants;
import com.bazra.usermanagement.service.SettingService;

@RestController
@CrossOrigin("*")
@RequestMapping("/Settings")
@Api(value = "Admin Setting Endpoint", description = "HERE WE Bazra Wallet Admin Has An Access to See Number Of Agents, Total Number of Merchants, Total Number of Customers, Update Setting, Create Setting")
@ApiResponses(value ={
		@ApiResponse(code = 404, message = "web user that a requested page is not available "),
		@ApiResponse(code = 200, message = "The request was received and understood and is being processed "),
		@ApiResponse(code = 201, message = "The request has been fulfilled and resulted in a new resource being created "),
		@ApiResponse(code = 401, message = "The client request has not been completed because it lacks valid authentication credentials for the requested resource. "),
		@ApiResponse(code = 403, message = "Forbidden response status code indicates that the server understands the request but refuses to authorize it. ")

})
public class AdminSettings {
	@Autowired
	SettingService settingService;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	MerchantRepository merchantRepository;
	
	@PostMapping("/SetSetting")
    @ApiOperation(value ="This EndPoint Is To Set Configuration ")
    public ResponseEntity<?> setSetting(@RequestBody SettingRequest settingRequest,Authorization authorization) {
    	
        return settingService.setEntity(settingRequest);
    }
	
	@PostMapping("/CreateSetting")
    @ApiOperation(value ="This EndPoint Is To Create a Setting AS An Admin ")
    public ResponseEntity<?> createSetting(@RequestBody CreateSettingRequest createSettingRequest,Authorization authorization) {
    	
        return settingService.createSetting(createSettingRequest);
    }
	
	@GetMapping("/TotalAgents")
    @ApiOperation(value ="This EndPoint To Get Total Number of Agents")
    public ResponseEntity<?> getNumberOfAgents(Authentication authentication) {
		
		List<AgentInfo> agentInfo = agentRepository.findAll();
		return ResponseEntity.ok(new TotalResponseAgents(agentInfo.size(),"Total number of registered agents: "+agentInfo.size()));
        
    }
	
	@GetMapping("/TotalCustomers")
    @ApiOperation(value ="This EndPoint To Get Total Number of Customers")
    public ResponseEntity<?> getNumberOfCustomers(Authentication authentication) {
		

		List<UserInfo> userInfo = userRepository.findAll();

		return ResponseEntity.ok(new TotalResponseCustomers(userInfo.size(),"Total number of registered customers: "+userInfo.size()));

        
    }
	
	@GetMapping("/TotalMerchants")
    @ApiOperation(value ="This EndPoint To Get Total Number of Merchants")
    public ResponseEntity<?> getNumberOfMerchants(Authentication authentication) {
		
		List<MerchantInfo> merchanInfo = merchantRepository.findAll();
		return ResponseEntity.ok(new TotalResponseMerchants(merchanInfo.size(),"Total number of registered customers: "+merchanInfo.size()));
        
    }
	
	
	

}
