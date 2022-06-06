package ma.enset.ebankingbackend.web;

import lombok.AllArgsConstructor;
import ma.enset.ebankingbackend.dtos.AccountOperationDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AccountOperationRestController {
    //AccountOperationService accountOperationService;

    @GetMapping("/operations")
    public List<AccountOperationDTO> getOperationsList(){
        return  null;
    }
}
