package me.dio.credit.application.system.annotation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDate
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [MaxDateValidator::class])
annotation class MaxDate(
    val maxMonths: Long,
    val message: String = "A data deve ser no máximo {maxMonths} meses a partir da data atual.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class MaxDateValidator : ConstraintValidator<MaxDate, LocalDate> {

    private lateinit var maxDate: LocalDate

    override fun initialize(constraintAnnotation: MaxDate) {
        maxDate = LocalDate.now().plusMonths(constraintAnnotation.maxMonths)
    }

    override fun isValid(date: LocalDate?, context: ConstraintValidatorContext): Boolean {
        return date == null || date.isBefore(maxDate)
    }
}

