package me.dio.credit.application.system.services.impl

import me.dio.credit.application.system.exception.BusinessException
import me.dio.credit.application.system.model.Credit
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.services.ICreditService
import org.springframework.stereotype.Service
import java.util.*
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService{
    override fun save(credit: Credit): Credit{
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit =
            (   this.creditRepository.findByCreditCode(creditCode)
                ?: throw BusinessException("Credit code $creditCode not found"))

        return (
                if (credit.customer?.id == customerId) credit
                else throw BusinessException("Contact Admin")
                )
    }
}