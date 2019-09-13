package org.demo.closeable.tool;

public interface ServiceCall extends AutoCloseable {

    @Override
    void close() ;

    void beforeServiceCall() ;

    void afterServiceCall() ;
    
}
