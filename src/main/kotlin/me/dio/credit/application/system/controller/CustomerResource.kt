package me.dio.credit.application.system.controller

import me.dio.credit.application.system.controller.dto.CustomerDto
import me.dio.credit.application.system.controller.dto.CustomerUpdateDto
import me.dio.credit.application.system.controller.dto.CustomerView
import me.dio.credit.application.system.model.Customer
import me.dio.credit.application.system.services.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/costumer")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved"
    }

    @GetMapping("/{customerId}")
    fun findById(@PathVariable customerId: Long): CustomerView{
        val customer: Customer = this.customerService.findById(customerId)
        return CustomerView(customer)
    }

    @DeleteMapping("/{customerId}")
    fun deleteCustomer(@PathVariable customerId: Long){
        this.customerService.delete(customerId)
    }

    @PatchMapping
    fun update(
        @RequestParam(value = "customerId") customerId: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView
    {
        val customer = this.customerService.findById(customerId)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }
}