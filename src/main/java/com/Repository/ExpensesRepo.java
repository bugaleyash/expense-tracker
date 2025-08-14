package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Expense;

public interface ExpensesRepo extends JpaRepository<Expense, Integer> {

	List<Expense>findByCategoryIgnoreCase(String Category);
	List<Expense>findByAmountOrderByTitleAsc(double amount);
}
