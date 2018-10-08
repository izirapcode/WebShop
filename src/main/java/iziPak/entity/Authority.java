package iziPak.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="authorities")
public class Authority implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private Account account;

    @Id
    @Column(name = "authority")
    private String authority;

    public Authority (){
    }

    public Authority(String authority){
        this.authority= authority;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(account, authority1.account) &&
                Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, authority);
    }
}
