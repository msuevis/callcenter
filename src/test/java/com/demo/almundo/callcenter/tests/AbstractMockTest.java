package com.demo.almundo.callcenter.tests;

import org.assertj.core.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that defines common mock test configuration and utilities
 *
 * @author Miguel Angel Suevis (manuel.vieda@payulatam.com)
 * @since 1.0
 */
public abstract class AbstractMockTest {

    /**
     * list of all declared methods
     */
    protected Object[] declaredMocks;

    /**
     * Set up test environment injecting mocks into target class.
     *
     * @see MockitoAnnotations#initMocks(Object)
     */
    @BeforeClass
    public void initMocks() {

        MockitoAnnotations.initMocks(this);

        List<Object> declaredMocks = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (field.isAnnotationPresent(Mock.class) || field.isAnnotationPresent(Spy.class)) {
                try {
                    declaredMocks.add(field.get(this));
                } catch (IllegalAccessException e) {
                    Assertions.fail("Unexpected exception configuring mocks", e);
                }
            }
        }

        this.declaredMocks = declaredMocks.toArray(new Object[0]);
    }

    /**
     * Reset all declared mocks before each test method
     */
    @BeforeMethod
    public void resetMocks() {

        Mockito.reset(declaredMocks);
    }
}