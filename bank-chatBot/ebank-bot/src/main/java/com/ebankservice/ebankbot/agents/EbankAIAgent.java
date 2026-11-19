package com.ebankservice.ebankbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EbankAIAgent {

    private ChatClient chatClient;

    public EbankAIAgent(ChatClient.Builder chatClient, ChatMemory chatMemory, ToolCallbackProvider tools) {
        this.chatClient = chatClient
                .defaultSystem("""
                        Vous un assistant qui se charge de répondre aux question de l'utilisateur 
                        a propos des clients et des comptes bancaires, en fonction de context fournis.
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor
                        .builder(chatMemory).build())
                .defaultTools(tools)
                .build();
    }

    public String chat(String query) {
        return chatClient.prompt(query)
                .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, "ID-session"))
                .call()
                .content();
    }

    public Flux<String> chatStream(Prompt prompt) {
        return chatClient.prompt(prompt).advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, "ID-session")).stream().content();
    }
}
