package es.ventura24.demo.web.user;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by jsanc on 28/08/15.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> findAllUsers() {

        return userRepository.findAll();
    }


    public Optional<Usuario> findById(final Long id) {
        return userRepository.findById(id);

    }
}
