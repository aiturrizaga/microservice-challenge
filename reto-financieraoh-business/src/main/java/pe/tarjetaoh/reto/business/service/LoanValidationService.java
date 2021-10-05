package pe.tarjetaoh.reto.business.service;

import org.springframework.stereotype.Service;
import pe.tarjetaoh.reto.business.common.type.ScoreType;
import pe.tarjetaoh.reto.business.dto.PersonalLoanDTO;
import pe.tarjetaoh.reto.business.exception.ExceptionResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

@Service
public class LoanValidationService {

    private static final int MIN_AGE_TO_LOAN = 21;

    public Optional<ExceptionResponse> businessValidation(PersonalLoanDTO dto) {
        Optional<ExceptionResponse> err;
        err = canAccessLoan(dto.getBirthday());
        if (err.isPresent()) {
            return err;
        }

        err = calculateAllowedLoan(dto.getScore(), dto.getLoanAmount());
        if (err.isPresent()) {
            return err;
        }

        err = calculateAllowedFees(dto.getScore(), dto.getTotalFees());
        if (err.isPresent()) {
            return err;
        }

        return Optional.empty();
    }

    public Optional<ExceptionResponse> canAccessLoan(LocalDate birthday) {
        Period period = Period.between(birthday, LocalDate.now());
        boolean allowedAge = period.getYears() >= MIN_AGE_TO_LOAN;
        return allowedAge ? Optional.empty() : buildLoanErrorMessage("Debe tener minimo " + MIN_AGE_TO_LOAN + " años para poder acceder a un prestamo");
    }

    public Optional<ExceptionResponse> calculateAllowedLoan(String score, BigDecimal amount) {
        switch (ScoreType.valueOf(score)) {
            case EXCELENTE:
                return amountNotAllowedMessage(amount, new BigDecimal(50000));
            case BUENA:
                return amountNotAllowedMessage(amount, new BigDecimal(20000));
            case REGULAR:
                return amountNotAllowedMessage(amount, new BigDecimal(8000));
            case MALA:
                return amountNotAllowedMessage(amount, new BigDecimal(2000));
            case PESIMA:
                return buildLoanErrorMessage("Debido a su calificación actual no puede acceder a un prestamo");
            default:
                return buildLoanErrorMessage("Tipo de calificación no disponible");
        }
    }

    public Optional<ExceptionResponse> calculateAllowedFees(String score, int totalFees) {
        switch (ScoreType.valueOf(score)) {
            case EXCELENTE:
                return feesNotAllowedMessage(totalFees, 12, 56);
            case BUENA:
                return feesNotAllowedMessage(totalFees, 12, 48);
            case REGULAR:
                return feesNotAllowedMessage(totalFees, 12, 36);
            default:
                return feesNotAllowedMessage(totalFees, 6, 12);
        }
    }

    public Optional<ExceptionResponse> buildLoanErrorMessage(String details) {
        return Optional.of(new ExceptionResponse(LocalDateTime.now(), "No puede acceder a un prestamo", details));
    }

    private Optional<ExceptionResponse> amountNotAllowedMessage(BigDecimal loanAmount, BigDecimal maxLoanAmount) {
        boolean validAmount = loanAmount.compareTo(maxLoanAmount) <= 0;
        return validAmount ? Optional.empty() : buildLoanErrorMessage("Debido a su calificación actual no puede acceder a un prestamo mayor a " + maxLoanAmount);
    }

    private Optional<ExceptionResponse> feesNotAllowedMessage(int totalFees, int minFees, int maxFees) {
        boolean validFees = (totalFees >= minFees) && (totalFees <= maxFees);
        return validFees ? Optional.empty() : buildLoanErrorMessage(String.format("Las cuotas deben estar entre %d y %d", minFees, maxFees));
    }

}
