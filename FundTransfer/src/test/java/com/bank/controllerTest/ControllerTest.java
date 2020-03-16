package com.bank.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bank.dto.AccountCreate;
import com.bank.dto.Deposit;
import com.bank.exception.InsufficientAmountException;
import com.bank.service.AccountService;
import com.bank.web.controller.FundController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	@Mock
	private AccountService accountService;
	@InjectMocks
	private FundController fundController;
	private MockMvc mocmvc;
	@Test
	public void withdrawTest() throws InsufficientAmountException 
	{
		/*
		 * AccountCreate account=new AccountCreate(); account.setAccountNo(50001L);
		 * account.setBalance(10000); account.setIfsc("afc123");
		 * accountService.addAccount(account); Deposit deposit=new Deposit();
		 * deposit.setAccountNumber(50001L); deposit.setAmount(10000.0);
		 * assertThat(accountService.withdraw(50001L,10000),fundController.withdraw(
		 * deposit));
		 */
		
		mocmvc.perform(post("/bank/account/acc"));
		
	}

}
