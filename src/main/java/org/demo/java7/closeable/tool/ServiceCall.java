package org.demo.java7.closeable.tool;

public interface ServiceCall extends AutoCloseable {

    @Override
    void close() ;

    void beforeServiceCall() ;

    void afterServiceCall() ;
    
}
