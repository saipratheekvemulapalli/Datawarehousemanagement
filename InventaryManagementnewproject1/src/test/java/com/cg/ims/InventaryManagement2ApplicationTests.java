package com.cg.ims;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ims.dto.CustomerDTO;
import com.cg.ims.exception.CustomerException;
import com.cg.ims.repository.ICustomerRepository;
import com.cg.ims.service.ICustomerServiceImpl;
import org.mockito.Mock;

@SpringBootTest
class InventaryManagement2ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Mock

    ICustomerRepository customerRepository;

    @Mock

    ICustomerServiceImpl customerService;

    

    @Test

    public void testgetAllCustomers() throws CustomerException {

        List<CustomerDTO> cust = new ArrayList<>();

        cust.add(new CustomerDTO());

        cust.add(new CustomerDTO());

        when(customerService.viewAllCustomer()).thenReturn(cust);

        assertEquals(2, cust.size());

        assertThat(cust.size()).isGreaterThan(0);

    }

    @Test

       public void testRemoveCustomer () throws CustomerException{

           CustomerDTO a=new CustomerDTO();

           

           when(customerService.removeCustomer(1)).thenReturn(a).thenThrow(CustomerException.class);

           

           

       }

    @Test

    public void testAddCustomer() throws CustomerException  {

        CustomerDTO c=new CustomerDTO();

        c.setCustomerId(1);

        when(customerService.addCustomer(c)).thenReturn(c);

        assertEquals(1,customerService.addCustomer(c).getCustomerId());

            

    }

}
