package com.trilogyed.gamestoreinvoicing.repository;


import com.trilogyed.gamestoreinvoicing.model.Invoice;
import com.trilogyed.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.GameViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.TShirtViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    List<Invoice> findByName(String name);

}
