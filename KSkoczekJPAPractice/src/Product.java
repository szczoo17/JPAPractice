import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String ProductName;
    private int UnitsOnStock;
    @ManyToOne
    @JoinColumn (name="SUPPLIER_FK")
    private Supplier supplier;

    @ManyToMany (mappedBy = "Products", cascade = CascadeType.PERSIST)
    private Set<BSTransaction> Transactions;

    public Product () {
        Transactions = new HashSet<BSTransaction>();
    }

    public Product(String productName, int unitsOnStock) {
        Transactions = new HashSet<BSTransaction>();
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
    }

    public String getProductName() {
        return ProductName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Set<BSTransaction> getTransactions() {
        return Transactions;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        supplier.getSupplies().add(this);
    }

    public void addTransaction(BSTransaction transaction) {
        Transactions.add(transaction);
        transaction.getProducts().add(this);
    }
}

