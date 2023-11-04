package org.explore.reactive;

import org.explore.reactive.utils.ResourceStreamUtils;
import reactor.core.publisher.Flux;

/**
 * @author anoopdeshpande
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        ResourceStreamUtils.stringFlux()
                        .doOnNext(item -> System.out.println("In the chain, before map " + item))
                        .map(String::toUpperCase)
                        .doOnNext(item -> System.out.println("In the chain " + item))
                        .subscribe(System.out::println, Throwable::printStackTrace,() -> System.out.println("StringFlux publisher complete"));

        ResourceStreamUtils.errorStringMono()
                .doOnError(e -> System.out.println("In the chain " + e.getMessage()))
                .subscribe(System.out::println, err -> System.out.println(err.getMessage()), () -> System.out.println("Publisher complete"));

        System.in.read();
    }
}
