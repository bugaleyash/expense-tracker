package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.ExpensesDto;
import com.Entity.Expense;
import com.Exception.ExpenseNotFound;
import com.Repository.ExpensesRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpensesRepo er;
	
	
	@Override
	public Expense addExpense(ExpensesDto ed) {
		Expense expense = new Expense();
		expense.setTitle(ed.getTitle());
		expense.setCategory(ed.getCategory());
		expense.setAmount(ed.getAmount());
		expense.setDate(ed.getDate());

		return er.save(expense);
	}

	@Override
	public List<Expense> getAllExpenses() {
		
		return er.findAll();
	}

	@Override
	public Expense getExpenseById(Integer id) throws ExpenseNotFound  {
		Expense e = er.getReferenceById(id);
		if(e!=null) {
			return e;
		}
		else {
			throw new ExpenseNotFound("Expense Not Found !"+id);
		}
	}

	@Override
	public List<Expense> getExpenseByCategory(String category) {
		
		return er.findByCategoryIgnoreCase(category);
	}

	@Override
	public Double getTotalAmount() {
		return er.findAll().stream().mapToDouble(Expense::getAmount).sum();
	}

	@Override
	public Expense updateExpense(Integer id, ExpensesDto ed) throws ExpenseNotFound {
		Expense e= getExpenseById(id);
		e.setTitle(ed.getTitle());
		e.setCategory(ed.getCategory());
		e.setAmount(ed.getAmount());
		e.setDate(ed.getDate());
		return er.save(e);
	}

	@Override
	public void deleteExpense(Integer id) throws ExpenseNotFound {
		Expense existing = getExpenseById(id);
        er.delete(existing);
	}

}
