package com.bank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.Deposit;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.exception.InsufficientAmountException;
import com.bank.service.AccountService;
import com.bank.dto.*;
@RestController
public class FundController {
	@Autowired
	private AccountService accountService; 
	
	@PostMapping(value = "/bank/account/acc")
	public ResponseEntity<Void>withdraw(@RequestBody Deposit deposit ) throws InsufficientAmountException
	{
		accountService.withdraw(deposit.getAccountNumber(),deposit.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	@PostMapping(value = "/bank/account")
	public ResponseEntity<Void>deposit(@RequestBody Deposit deposit )
	{
		accountService.deposit(deposit.getAccountNumber(),deposit.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	@PutMapping(value = "/bank/account") 
	public ResponseEntity<Void>FundTransfer(@RequestBody FundTransfer req )throws FundTransferLimitExceededException
	{
		accountService.fundTransfer(req.getFromAccountNumber(),req.getToAccountNumber(),req.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	
}
