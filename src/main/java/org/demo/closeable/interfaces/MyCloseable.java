package org.demo.closeable.interfaces;

public interface MyCloseable extends AutoCloseable {

    @Override
    void close() ;

}
