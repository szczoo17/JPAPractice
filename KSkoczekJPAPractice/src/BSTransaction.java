import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Transactions")
public class BSTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TransactionNumber;
    private int Quantity;

    @ManyToMany (cascade = CascadeType.PERSIST)
    private Set<Product> Products;

    public BSTransaction() {
        Products = new HashSet<Product>();
    }

    public BSTransaction(int quantity) {
        Quantity = quantity;
        Products = new HashSet<Product>();
    }

    public int getTransactionNumber() {
        return TransactionNumber;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public void addProduct(Product product) {
        product.addTransaction(this);
    }
}
