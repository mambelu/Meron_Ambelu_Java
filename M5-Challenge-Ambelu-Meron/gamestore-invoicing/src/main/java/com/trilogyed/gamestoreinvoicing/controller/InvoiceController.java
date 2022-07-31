package com.trilogyed.gamestoreinvoicing.controller;

import com.trilogyed.gamestoreinvoicing.model.Invoice;
import com.trilogyed.gamestoreinvoicing.service.InvoiceService;
import com.trilogyed.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.GameViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.TShirtViewModel;
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

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manu){
        return service.getConsoleByManufacturer(manu);
    }




    @PostMapping("/purchaseInvoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createPurchaseOrder(@RequestBody @Valid Invoice invoice) {
        return service.createInvoice(invoice);
    }

    @GetMapping("tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") long tShirtId){
        return service.getTShirt(tShirtId);
    }

    @GetMapping("tshirt/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size){
        return service.getTShirtsBySize(size);
    }

    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") long gameId){
        return service.getGame(gameId);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio){
       return service.getGamesByStudio(studio);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames(){
       return service.getAllGames();
    }

    @GetMapping("tshirt/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color){
        return service.getTShirtsByColor(color);
    }

    @GetMapping("/tshirt")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getShirts(){
        return service.getAllTShirts();
    }





}
