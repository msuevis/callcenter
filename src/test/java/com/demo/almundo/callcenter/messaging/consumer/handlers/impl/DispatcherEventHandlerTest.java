package com.demo.almundo.callcenter.messaging.consumer.handlers.impl;

import com.demo.almundo.callcenter.messaging.consumer.EventDispatcher;
import com.demo.almundo.callcenter.messaging.consumer.events.impl.DispatchCallEvent;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.models.Employee;
import com.demo.almundo.callcenter.service.ICallService;
import com.demo.almundo.callcenter.service.EmployeeService;
import com.demo.almundo.callcenter.tests.AbstractMockTest;
import org.junit.Before;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * Test suite for {@linkplain DispatcherEventHandler} class
 *
 * @author Miguel Angel Suevis (miguel.suevis@payulatam.com)
 * @since 1.0
 */
public class DispatcherEventHandlerTest extends AbstractMockTest{

    /**
     *  eventDispatcher mock
     */
    @Spy
    private  EventDispatcher dispatcher =new EventDispatcher();

    /**
     * DispatchCallEvent  mock
     */
    @Spy
    private DispatchCallEvent dispatchCallEvent=new DispatchCallEvent();


    /**
     * Call Service mock
     */
    @Mock
    private ICallService ICallService;

    /**
     * Employee Service mock
     */
    @Mock
    private EmployeeService employeeService;

    @Mock
    private ExecutorService executorService;

    /**
     * num call comcurrent calls
     */
    private int NUM_COMCURRENT_CALLS = 10;

    @InjectMocks
    DispatcherEventHandler dispatcherEventHandler =new DispatcherEventHandler();

    @InjectMocks
    CompletableFuture completableFuture;


    /**
     * Set up test environment injecting mocks into target class.
     *
     * @see MockitoAnnotations#initMocks(Object)
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    /**
     * Test case for {@linkplain DispatcherEventHandler} constructor
     *
     * @author Miguel Angel Suevis Pacheco (miguel.suevis@payulatam.com)
     * @date 19/03/2018
     */
    @Test
    public void testDispatchCallSuccessfully() {

        EventDispatcher dispatcher = Mockito.spy(new EventDispatcher());

        Mockito.when(ICallService.getCall()).thenReturn(Optional.of(Call.create().withMessage("Hola").build()));
        Mockito.when(employeeService.getAvalibleEmployee()).thenReturn(Optional.of(Employee.create().build()));

        Mockito.doAnswer((InvocationOnMock invocation)-> {
            ((Runnable) invocation.getArguments()[0]).run();
            return null;
        }).when(executorService).execute(Mockito.any(Runnable.class));


        dispatcher.registerHandler(DispatchCallEvent.class, dispatcherEventHandler);

        dispatcherEventHandler.dispatchCall(new DispatchCallEvent());

        Mockito.verify(ICallService).getCall();
        Mockito.verify(employeeService).getAvalibleEmployee();
        Mockito.verify(employeeService).answerPhoneCall(Mockito.any(Employee.class),Mockito.any(Call.class));

    }

}
