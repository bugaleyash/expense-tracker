package com.Service;

import java.util.List;

import com.DTO.ExpensesDto;
import com.Entity.Expense;
import com.Exception.ExpenseNotFound;

public interface ExpenseService {

	Expense addExpense(ExpensesDto ed);
	List<Expense>getAllExpenses();
	Expense getExpenseById(Integer id) throws ExpenseNotFound;
	List<Expense> getExpenseByCategory(String category);
	Double getTotalAmount();
    Expense updateExpense(Integer id, ExpensesDto ed) throws ExpenseNotFound;
    void deleteExpense(Integer id) throws ExpenseNotFound;
}
