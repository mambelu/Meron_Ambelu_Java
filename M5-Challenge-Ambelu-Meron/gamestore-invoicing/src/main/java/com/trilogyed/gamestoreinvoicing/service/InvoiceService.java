package com.trilogyed.gamestoreinvoicing.service;


import com.trilogyed.gamestoreinvoicing.model.Invoice;
import com.trilogyed.gamestoreinvoicing.model.ProcessingFee;
import com.trilogyed.gamestoreinvoicing.model.Tax;
import com.trilogyed.gamestoreinvoicing.repository.InvoiceRepository;
import com.trilogyed.gamestoreinvoicing.repository.ProcessingFeeRepository;
import com.trilogyed.gamestoreinvoicing.repository.TaxRepository;
import com.trilogyed.gamestoreinvoicing.util.GamestoreInvoicingClient;
import com.trilogyed.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.GameViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component

public class InvoiceService {

    private final BigDecimal PROCESSING_FEE = new BigDecimal("15.49");
    private final BigDecimal MAX_INVOICE_TOTAL = new BigDecimal("999.99");
    private final String GAME_ITEM_TYPE = "Game";
    private final String CONSOLE_ITEM_TYPE = "Console";
    private final String TSHIRT_ITEM_TYPE = "T-Shirt";

    InvoiceRepository invoiceRepo;
    TaxRepository taxRepo;
    ProcessingFeeRepository processingFeeRepo;


    @Autowired
    private GamestoreInvoicingClient client;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepo, TaxRepository taxRepo, ProcessingFeeRepository processingFeeRepo) {

        this.invoiceRepo = invoiceRepo;
        this.taxRepo = taxRepo;
        this.processingFeeRepo = processingFeeRepo;
    }


    public ConsoleViewModel getConsoleById(long consoleId) {

        return client.getConsole(consoleId);
    }

    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manu){
        return client.getConsoleByManufacturer(manu);
    }

    public List<ConsoleViewModel> getAllConsoles(){
        return client.getAllConsoles();
    }


    public GameViewModel getGame(long gameId) {
        return client.getGame(gameId);

    }


    public List<GameViewModel> getGamesByTitle(String title) {
    return client.getGamesByTitle(title);
    }

    public List<GameViewModel> getGamesByEsrbRating( String esrb) {

    return client.getGamesByEsrbRating(esrb);
    }

    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio){
       return client.getGamesByStudio(studio);
    }

    public List<GameViewModel> getAllGames(){
        return client.getAllGames();
    }



    public TShirtViewModel getTShirt( long tShirtId) {

        return client.getTShirt(tShirtId);
    }


    public List<TShirtViewModel> getTShirtsBySize( String size) {

        return client.getTShirtsBySize(size);
    }

    public List<TShirtViewModel> getTShirtsByColor( String color){
        return  client.getTShirtsByColor(color);
    }

    public List<TShirtViewModel> getAllTShirts(){
        return client.getAllTShirts();
    }


    public List<Invoice> getInvoicesByCustomerName(String name) {
        List<Invoice> invoiceList = invoiceRepo.findByName(name);
        List<Invoice> ivmList = new ArrayList<>();
        List<Invoice> exceptionList = null;

        if (invoiceList == null) {
            return exceptionList;
        } else {
            invoiceList.stream().forEach(i -> ivmList.add(buildInvoice(i)));
        }
        return ivmList;
    }



    public List<Invoice> getAllInvoices() {
        List<Invoice> invoiceList = invoiceRepo.findAll();
        List<Invoice> ivmList = new ArrayList<>();
        List<Invoice> exceptionList = null;

        if (invoiceList == null) {
            return exceptionList;
        } else {
            invoiceList.stream().forEach(i -> {
                ivmList.add(buildInvoice(i));
            });
        }
        return ivmList;
    }

    public Invoice buildInvoice(Invoice input) {
        Invoice invoice = new Invoice();
        invoice.setId(input.getId());
        invoice.setName(input.getName());
        invoice.setStreet(input.getStreet());
        invoice.setCity(input.getCity());
        invoice.setState(input.getState());
        invoice.setZipcode(input.getZipcode());
        invoice.setItemType(input.getItemType());
        invoice.setItemId(input.getItemId());
        invoice.setUnitPrice(input.getUnitPrice());
        invoice.setQuantity(input.getQuantity());
        invoice.setSubtotal(input.getSubtotal());
        invoice.setProcessingFee(input.getProcessingFee());
        invoice.setTax(input.getTax());
        invoice.setProcessingFee(input.getProcessingFee());
        invoice.setTotal(input.getTotal());

        return invoice;
    }


    public Invoice getInvoice(long id){
        Optional<Invoice> invoice = invoiceRepo.findById(id);
        if (invoice == null)
            return null;
        else
            return buildInvoice(invoice.get());
    }


    public Invoice createInvoice(Invoice input) {

        //validation...
        if (input == null)
            throw new NullPointerException("Create input failed. no invoice data.");

        if (input.getItemType() == null)
            throw new IllegalArgumentException("Unrecognized Item type. Valid ones: Console or Game");

        //Check Quantity is > 0...
        if (input.getQuantity() <= 0) {
            throw new IllegalArgumentException(input.getQuantity() +
                    ": Unrecognized Quantity. Must be > 0.");
        }
        //start building invoice...
        Invoice invoice = new Invoice();
        invoice.setName(input.getName());
        invoice.setStreet(input.getStreet());
        invoice.setCity(input.getCity());
        invoice.setState(input.getState());
        invoice.setZipcode(input.getZipcode());
        invoice.setItemType(input.getItemType());
        invoice.setItemId(input.getItemId());

        //Checks the item type and get the correct unit price
        //Check if we have enough quantity
        if (invoice.getItemType().equals(CONSOLE_ITEM_TYPE)) {
           ConsoleViewModel tempCon = null;
            Optional<ConsoleViewModel> returnVal = Optional.ofNullable(client.getConsole(invoice.getItemId()));

            if (returnVal.isPresent()) {
                tempCon = returnVal.get();
            } else {
                throw new IllegalArgumentException("Requested item is unavailable.");}


            if (invoice.getQuantity() > tempCon.getQuantity()) {
                throw new IllegalArgumentException("Requested quantity is unavailable.");
            }

            invoice.setUnitPrice(tempCon.getPrice());

        }  else if (invoice.getItemType().equals(GAME_ITEM_TYPE)) {
            GameViewModel tempGame = null;
            Optional<GameViewModel> returnVal = Optional.ofNullable(client.getGame(invoice.getItemId()));

            if (returnVal.isPresent()) {
                tempGame = returnVal.get();
            } else {
                throw new IllegalArgumentException("Requested item is unavailable.");
            }

            if(invoice.getQuantity() >  tempGame.getQuantity()){
                throw new IllegalArgumentException("Requested quantity is unavailable.");
            }
            invoice.setUnitPrice(tempGame.getPrice());

        } else if (invoice.getItemType().equals(TSHIRT_ITEM_TYPE)) {
            TShirtViewModel tempTShirt = null;
            Optional<TShirtViewModel> returnVal = Optional.ofNullable(client.getTShirt(invoice.getItemId()));

            if (returnVal.isPresent()) {
                tempTShirt = returnVal.get();
            } else {
                throw new IllegalArgumentException("Requested item is unavailable.");
            }

            if(invoice.getQuantity() >  tempTShirt.getQuantity()){
                throw new IllegalArgumentException("Requested quantity is unavailable.");
            }
            invoice.setUnitPrice(tempTShirt.getPrice());

        }else
            {
                throw new IllegalArgumentException(invoice.getItemType() +
                        ": Unrecognized Item type. Valid ones: T-Shirt, Console, or Game");
            }

            invoice.setQuantity(input.getQuantity());

            invoice.setSubtotal(
                    invoice.getUnitPrice().multiply(
                            new BigDecimal(input.getQuantity())).setScale(2, RoundingMode.HALF_UP));

            //Throw Exception if subtotal is greater than 999.99
            if ((invoice.getSubtotal().compareTo(new BigDecimal(999.99)) > 0)) {
                throw new IllegalArgumentException("Subtotal exceeds maximum purchase price of $999.99");
            }

            //Validate State and Calc tax...
            BigDecimal tempTaxRate;
            Optional<Tax> taxReturnVal = taxRepo.findById(invoice.getState());

            if (taxReturnVal.isPresent()) {
                tempTaxRate = taxReturnVal.get().getRate();
            } else {
                throw new IllegalArgumentException(invoice.getState() + ": Invalid State code.");
            }

            if (!tempTaxRate.equals(BigDecimal.ZERO))
                invoice.setTax(tempTaxRate.multiply(invoice.getSubtotal()));
            else
                throw new IllegalArgumentException(invoice.getState() + ": Invalid State code.");

            BigDecimal processingFee;
            Optional<ProcessingFee> returnVal2 = processingFeeRepo.findById(invoice.getItemType());

            if (returnVal2.isPresent()) {
                processingFee = returnVal2.get().getFee();
            } else {
                throw new IllegalArgumentException("Requested item is unavailable.");
            }

            invoice.setProcessingFee(processingFee);

            //Checks if quantity of items if greater than 10 and adds additional processing fee
            if (invoice.getQuantity() > 10) {
                invoice.setProcessingFee(invoice.getProcessingFee().add(PROCESSING_FEE));
            }

            invoice.setTotal(invoice.getSubtotal().add(invoice.getProcessingFee()).add(invoice.getTax()));

            //checks total for validation
            if ((invoice.getTotal().compareTo(MAX_INVOICE_TOTAL) > 0)) {
                throw new IllegalArgumentException("Subtotal exceeds maximum purchase price of $999.99");
            }

            invoice = invoiceRepo.save(invoice);

            return buildInvoice(invoice);
        }








    }
