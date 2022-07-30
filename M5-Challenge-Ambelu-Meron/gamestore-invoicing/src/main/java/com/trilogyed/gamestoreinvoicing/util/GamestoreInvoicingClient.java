package com.trilogyed.gamestoreinvoicing.util;

import com.trilogyed.gamestoreinvoicing.model.Invoice;
import com.trilogyed.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.GameViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "gameStore-catalog")
public interface GamestoreInvoicingClient {

    //    @RequestMapping(value = "/game", method = RequestMethod.GET)
//    public String getGames();
//
//    @RequestMapping(method = RequestMethod.GET, value = "/game")
//    List<Game> getStores();
//
//    @RequestMapping(method = RequestMethod.POST, value = "/game/{gameId}", consumes = "application/json")
//    Game update(@PathVariable("gameId") Long storeId, Game game);
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/game/{gameId}")
//    void delete(@PathVariable Long gameId);
    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") long consoleId);

    @PostMapping("/purchaseInvoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") long gameId);

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title);

    @GetMapping("/esrbrating/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable("esrb") String esrb);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") long tShirtId);


    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size);

}