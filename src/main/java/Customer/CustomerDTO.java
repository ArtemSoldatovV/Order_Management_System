package Customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @NotNull(message = "Id не может быть пустым")
    private Long Id;

    @NotNull(message = "name не может быть пустым")
    private String name;

    @NotEmpty(message = "Список ordersid не может быть пустым")
    private List<Long> ordersid;

    public void setId(Long id){
        this.Id=id;
    }
    public void setName(String name){
        this.name=name;
    }

    public long getId(){
        return this.Id;
    }
    public String grtName(){
        return this.name;
    }
}
