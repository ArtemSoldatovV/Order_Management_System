package Client;

import MappingUtils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository userRepository;

    @Autowired
    private MappingUtils mappingUtils;

    public List<ClientDTO> findAll() {
        return userRepository.findAll().stream()
                .map(mappingUtils::mapToUserDTO)
                .collect(Collectors.toList());
    }

    public List<Client>findById(Long id) {
        return (List<Client>) userRepository.findById(id).orElse(null);
    }
    public ClientService(ClientRepository clientRepository) {
        this.userRepository = userRepository;
    }

    public List<Client> getAllClients() {
        return userRepository.findAll();
    }
    public Client getClientByUsername(String name) {
        return userRepository.findAll().stream()
                .filter(s -> name.equals(s.getName())
                        || name.equals(s.getFullName()) )
                .findFirst().orElse(null);
    }

}
