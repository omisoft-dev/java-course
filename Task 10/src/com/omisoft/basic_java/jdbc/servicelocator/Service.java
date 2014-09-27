package com.omisoft.basic_java.jdbc.servicelocator;

/**
 * Create Service interface.
 * @author bkoprinski
 *
 */
public interface Service {
    public int validateAge() throws AgeServiceException;
}
