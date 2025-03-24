package User;

import MappingUtils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MappingUtils mappingUtils;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(mappingUtils::mapToUserDTO)
                .collect(Collectors.toList());
    }

    public List<User>findById(Long id) {
        return (List<User>) userRepository.findById(id).orElse(null);
    }
    public UserService(UserRepository clientRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllClients() {
        return userRepository.findAll();
    }

}
