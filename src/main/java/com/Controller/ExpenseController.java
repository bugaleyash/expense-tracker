package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.ExpensesDto;
import com.Entity.Expense;
import com.Exception.ExpenseNotFound;
import com.Service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpensesDto dto) {
        return ResponseEntity.ok(expenseService.addExpense(dto));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Expense> getExpenseById(@RequestParam Integer id) throws ExpenseNotFound {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@RequestParam String category) {
        return ResponseEntity.ok(expenseService.getExpenseByCategory(category));
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalAmount() {
        return ResponseEntity.ok(expenseService.getTotalAmount());
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestParam Integer id, @RequestBody ExpensesDto dto) throws ExpenseNotFound {
        return ResponseEntity.ok(expenseService.updateExpense(id, dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteExpense(@RequestParam Integer id) throws ExpenseNotFound {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}


