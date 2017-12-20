import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Suppliers")
@SecondaryTable(name = "ADDRESS_TBL")
public class Supplier {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String CompanyName;
    @Column(table = "ADDRESS_TBL")
    private String street;
    @Column(table = "ADDRESS_TBL")
    private String city;
    @Column(table = "ADDRESS_TBL")
    private String zipCode;
    @OneToMany (mappedBy = "supplier")
    private Set<Product> Supplies;

    public Supplier () {
        Supplies = new HashSet<Product>();
    }

    public Supplier (String companyName, String street, String city, String zipCode) {
        CompanyName = companyName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        Supplies = new HashSet<Product>();
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public Set<Product> getSupplies() {
        return Supplies;
    }

    public void addProduct(Product product) {
        Supplies.add(product);
        product.setSupplier(this);
    }
}