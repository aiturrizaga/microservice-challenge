package pe.tarjetaoh.reto.business.dto;

import pe.tarjetaoh.reto.business.common.type.ScoreType;
import pe.tarjetaoh.reto.business.common.validator.EnumValidator;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonalLoanDTO {
    private int id;

    @NotBlank(message = "{loan.names.not-null}")
    @Size(min = 3, max = 50, message = "{loan.names.size}")
    private String names;

    @NotBlank(message = "{loan.lastnames.not-null}")
    @Size(min = 3, max = 50, message = "{loan.lastnames.size}")
    private String lastnames;

    @NotNull(message = "{loan.birthday.not-null}")
    @Past(message = "{loan.birthday.date-past}")
    private LocalDate birthday;

    @NotBlank(message = "{loan.score.not-null}")
    @EnumValidator(enumClass = ScoreType.class, message = "{loan.score.invalid-type}")
    private String score;

    @Positive(message = "{loan.amount.positive}")
    private BigDecimal loanAmount;

    @Positive(message = "{loan.fees.positive}")
    private int totalFees;

    private LocalDateTime loanDate = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
}
