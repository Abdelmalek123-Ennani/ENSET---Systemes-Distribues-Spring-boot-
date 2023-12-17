package ma.abdelmalek.comptecqrses.commands.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.abdelmalek.comptecqrses.commandApi.commands.CreateAccountCommand;
import ma.abdelmalek.comptecqrses.commandApi.dtos.CreateAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path="/commands/account")
@AllArgsConstructor @NoArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;
    @PostMapping(path = "/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request) {
        CompletableFuture<String>  commandResponse = commandGateway.send(
                new CreateAccountCommand(
                        UUID.randomUUID().toString(),
                        request.getIntialBalance(),
                        request.getCurrency()
                )
        );

        return commandResponse;
    };
}