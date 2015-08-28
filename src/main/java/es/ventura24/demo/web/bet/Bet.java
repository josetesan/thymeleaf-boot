package es.ventura24.demo.web.bet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by jsanc on 28/08/15.
 */
public class Bet implements Serializable{

    private Long id;
    private String product;
    private BigDecimal amount;

    public Bet(Long id, String product, BigDecimal amount) {
        this.id = id;
        this.product = product;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bet)) return false;
        Bet bet = (Bet) o;
        return Objects.equals(id, bet.id) &&
                Objects.equals(product, bet.product) &&
                Objects.equals(amount, bet.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bet{");
        sb.append("id=").append(id);
        sb.append(", product='").append(product).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
