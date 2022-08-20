
package arg.com.gym.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuarios")
@Data
public class Usuario implements Serializable{
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idUsuario;

    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @OneToMany
    @JoinColumn(name="idUsuario")
    private List<Rol> roles;
}
