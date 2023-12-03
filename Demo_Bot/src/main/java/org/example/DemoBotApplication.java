/**
 * demo bot
 *
 * @version 1.0 from 2023-12-02
 * @author Valentyn Mozul
 */

package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.telegram.telegrambots.starter.TelegramBotInitializer;
import org.telegram.telegrambots.starter.TelegramBotStarterConfiguration;

@SpringBootApplication
@Import(TelegramBotStarterConfiguration.class)
public class DemoBotApplication {
    /**
     * Program entry point.
     *
     * @param args command Line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoBotApplication.class, args);
    }
}