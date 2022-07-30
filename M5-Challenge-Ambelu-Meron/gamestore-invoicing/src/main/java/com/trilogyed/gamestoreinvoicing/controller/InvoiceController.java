package com.trilogyed.gamestoreinvoicing.controller;

import com.trilogyed.gamestoreinvoicing.model.Invoice;
import com.trilogyed.gamestoreinvoicing.service.InvoiceService;
import com.trilogyed.gamestoreinvoicing.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
@CrossOrigin(origins = {"http://localhost:3000"})
public class InvoiceController {

    @Autowired
    InvoiceService service;

    // Assumption: All orders are final and data privacy is not top priority. Therefore, the Update & Delete EndPoints
    // are left out by design due to its potential danger. The getAllInvoices is a questionable one since it could
    // overwhelm the system and infringes on data privacy; however, it does not damage data as with the Update and Delete

////    @PostMapping
////    @ResponseStatus(HttpStatus.CREATED)
////    public Invoice purchaseItem(@RequestBody @Valid Invoice Invoice) {
////        Invoice = service.createInvoice(Invoice);
////        return Invoice;
////    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Invoice findInvoice(@PathVariable("id") long invoiceId) {
//        Invoice Invoice = service.getInvoice(invoiceId);
//        if (Invoice == null) {
//            throw new IllegalArgumentException("Invoice could not be retrieved for id " + invoiceId);
//        } else {
//            return Invoice;
//        }
//    }
//
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<Invoice> findAllInvoices() {
//        List<Invoice> InvoiceList = service.getAllInvoices();
//
//        if (InvoiceList == null || InvoiceList.isEmpty()) {
//            throw new IllegalArgumentException("No invoices were found.");
//        } else {
//            return InvoiceList;
//        }
//    }
//
//    @GetMapping("/cname/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Invoice> findInvoicesByCustomerName(@PathVariable String name) {
//        List<Invoice> InvoiceList = service.getInvoicesByCustomerName(name);
//
//        if (InvoiceList == null || InvoiceList.isEmpty()) {
//            throw new IllegalArgumentException("No invoices were found for: "+name);
//        } else {
//            return InvoiceList;
//        }
//    }

    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") long consoleId) {
        ConsoleViewModel consoleViewModel = service.getConsoleById(consoleId);
        if (consoleViewModel == null) {
            throw new IllegalArgumentException("Console could not be retrieved for id " + consoleId);
        } else {
            return consoleViewModel;
        }
    }

    @PostMapping("/purchaseInvoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createPurchaseOrder(@RequestBody @Valid Invoice invoice) {
        return service.createInvoice(invoice);
    }


}
