package es.ventura24.demo.web.user;

import es.ventura24.demo.web.bet.Bet;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by jsanc on 28/08/15.
 */
@Component("usuario")
public class Usuario implements Serializable {

    private Long id;
    private String name;
    private List<Bet> bets;

    public Usuario() {
    }

    public Usuario(Long id, String name, List<Bet> bets) {
        this.id = id;
        this.name = name;
        this.bets = bets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(name, usuario.name) &&
                Objects.equals(bets, usuario.bets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bets);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", bets=").append(bets);
        sb.append('}');
        return sb.toString();
    }
}
