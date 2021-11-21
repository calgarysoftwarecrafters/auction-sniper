package org.auctionsniper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.auctionsniper.AuctionsniperApp;
import org.auctionsniper.ReactiveSqlTestContainerExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = AuctionsniperApp.class)
@ExtendWith(ReactiveSqlTestContainerExtension.class)
public @interface IntegrationTest {
}
