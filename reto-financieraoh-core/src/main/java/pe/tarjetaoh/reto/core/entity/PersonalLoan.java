package pe.tarjetaoh.reto.core.entity;

import pe.tarjetaoh.reto.core.type.ScoreType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRESTAMO_PERSONAL")
public class PersonalLoan {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "nombre", length = 50, nullable = false)
    private String names;

    @NotNull
    @Column(name = "apellido", length = 50, nullable = false)
    private String lastnames;

    @NotNull
    @Column(name = "fec_nac", nullable = false)
    private LocalDate birthday;

    @NotNull
    @Column(name = "tipo_calificacion", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private ScoreType score;

    @NotNull
    @Column(name = "monto_prestamo", nullable = false)
    private BigDecimal loanAmount;

    @NotNull
    @Column(name = "total_cuotas", nullable = false)
    private int totalFees;

    @Column(name = "fec_prestamo")
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

    public ScoreType getScore() {
        return score;
    }

    public void setScore(ScoreType score) {
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
