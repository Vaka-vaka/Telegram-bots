/**
 * demo bot
 *
 * @version 1.0 from 2023-12-02
 * @author Valentyn Mozul
 */

package org.example.bot.commands;

//import com.example.demobot.bot.constants.Actions;

import org.example.bot.constans.Actions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class StartCommandsHandler extends BotCommand {

    private String startSecret;
    /**
     * Construct a command
     *
     * @param commandIdentifier the unique identifier of this command (e.g. the command string to
     *                          enter into chat)
     * @param description       the description of this command
     */
    public StartCommandsHandler(@Value("start") String commandIdentifier,
                                @Value("") String description,
                                @Value("${bot.start-secret}") String secret) {
        super(commandIdentifier, description);
        this.startSecret = secret;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        if (arguments.length == 0) {
            return;
        }
        var secret = arguments[0];
        if (!startSecret.equals(secret)) {
            return;
        }

        try {
            var replyMarkup = InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(
                            InlineKeyboardButton.builder()
                                    .text("I'm link to youtube chat")
                                    .url("https://www.youtube.com/live_chat?is_popout=1&v=lQ-_F2NUAiE")
                                    .build(),
                            InlineKeyboardButton.builder()
                                    .text("I'm callback button")
                                    .callbackData(Actions.SOME_ACTION)
                                    .build()
                    ))
                    .build();
            var sendMassage = SendMessage.builder()
                    .chatId(chat.getId())
                    .text("Some text")
                    .replyMarkup(replyMarkup)
                    .build();
            absSender.execute(sendMassage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
