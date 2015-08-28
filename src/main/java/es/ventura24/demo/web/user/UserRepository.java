package es.ventura24.demo.web.user;

import es.ventura24.demo.web.bet.Bet;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jsanc on 28/08/15.
 */
@Repository
public class UserRepository {


    static List<Usuario> usuarios =
        Arrays.asList(
                new Usuario(1L,"josete", Arrays.asList(
                        new Bet(1L,"Euromillones",new BigDecimal(100.319d)),
                        new Bet(2L,"Primitiva",new BigDecimal(32.41d))
                )),
                new Usuario(2L,"filete", Collections.EMPTY_LIST),
                new Usuario(3L,"capi", Collections.EMPTY_LIST),
                new Usuario(4L,"mario", Arrays.asList(
                        new Bet(1L,"Euromillones",new BigDecimal(100.432d)),
                        new Bet(2L,"Primitiva",new BigDecimal(32.48d))
                ))
        );


    /**
     *
     * @return
     */
    public List<Usuario> findAll() {
        return usuarios;

    }


    public Optional<Usuario> findById(Long id) {
        return usuarios
                .parallelStream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst();
    }
}
