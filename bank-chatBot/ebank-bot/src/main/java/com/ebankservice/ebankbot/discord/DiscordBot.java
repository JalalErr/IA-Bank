package com.ebankservice.ebankbot.discord;

import com.ebankservice.ebankbot.agents.EbankAIAgent;

import com.zgamelogic.discord.annotations.DiscordMapping;
import com.zgamelogic.discord.annotations.DiscordController;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@DiscordController
public class DiscordBot {

    private EbankAIAgent ebankAIAgent;

    public DiscordBot(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @DiscordMapping
    private void perform(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String respnse = ebankAIAgent.chat(query);
        event .getChannel().sendMessage(respnse).queue();
    }
}