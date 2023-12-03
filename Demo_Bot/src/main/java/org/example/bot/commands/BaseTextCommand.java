/**
 * demo bot
 *
 * @version 1.0 from 2023-12-02
 * @author Valentyn Mozul
 */

package org.example.bot.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public abstract class BaseTextCommand implements IBotCommand {
    private final String textCommandIdentified;
    private final String description;

    public BaseTextCommand(String textCommandIdentified, String description) {
        this.textCommandIdentified = textCommandIdentified;
        this.description = description;
    }

    @Override
    public String getCommandIdentifier() {
        return textCommandIdentified;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
