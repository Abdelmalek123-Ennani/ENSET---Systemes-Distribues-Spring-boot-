package ma.abdelmalek.comptecqrses.commandApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateAccountRequestDTO {
    private double intialBalance;
    private String currency;
}
