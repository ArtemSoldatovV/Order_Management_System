package User_and_Admin;

import Client.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService; // Сервис для работы с клиентами

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/api/clients")
    public List<Client> getAllClients() {
        // Этот метод будет доступен только администраторам
        return clientService.getAllClients();
    }

    @GetMapping("/api/clients/me")
    public Client getMyData(@AuthenticationPrincipal UserDetails userDetails) {
        // Этот метод будет доступен только пользователям
        return clientService.getClientByUsername(userDetails.getUsername());
    }
}