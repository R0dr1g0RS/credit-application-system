package me.dio.credit.application.system.services.impl

import me.dio.credit.application.system.model.Customer
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.services.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(customerId: Long): Customer =
        this.customerRepository.findById(customerId).orElseThrow{
            throw RuntimeException("ID $customerId not found")
        }

    override fun delete(customerId: Long) =
        this.customerRepository.deleteById(customerId)


}