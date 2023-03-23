package seedu.duke;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseManagerTest {

    ArrayList<Expense> testExpenses;
    ExpenseManager testManager;

    @BeforeEach
    public void setUp() {
        LocalDate date = LocalDate.of(2022, 01, 01);
        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("Movie", 20, date, "Life & Entertainment"));
        expenses.add(new Expense("Trip", 200.1, date, "Life & Entertainment"));
        expenses.add(new Expense("Food", 10.4, date, "Life & Entertainment"));
        expenses.add(new Expense("Laptop", 3000, date, "Life & Entertainment"));
        expenses.add(new Expense("Bag", 50.2, date, "Life & Entertainment"));
        this.testExpenses = expenses;

        ExpenseManager expenseManager = new ExpenseManager(0);
        expenseManager.addExpense("Movie", 20, date, "Life & Entertainment");
        expenseManager.addExpense("Trip", 200.1, date, "Life & Entertainment");
        expenseManager.addExpense("Food", 10.4, date, "Life & Entertainment");
        expenseManager.addExpense("Laptop", 3000, date, "Life & Entertainment");
        expenseManager.addExpense("Bag", 50.2, date, "Life & Entertainment");
        this.testManager = expenseManager;
    }

    @Test
    public void sortExpensesByName_successful() {
        ArrayList<Expense> controlExpense = new ArrayList<>(this.testExpenses);
        controlExpense.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        ArrayList<Expense> testingExpense = this.testManager.getSortedExpenses(ExpenseManager.SORT_BY_NAME);
        assertEquals(controlExpense, testingExpense, "Expenses are sorted by name correctly");
    }

    @Test
    public void sortExpensesByPrice_successful() {
        ArrayList<Expense> controlExpense = new ArrayList<>(this.testExpenses);
        controlExpense.sort((e1, e2) -> Double.compare(e1.getAmount(), e2.getAmount()));
        ArrayList<Expense> testingExpense = this.testManager.getSortedExpenses(ExpenseManager.SORT_BY_PRICE);
        assertEquals(controlExpense, testingExpense, "Expenses are sorted by price correctly");
    }
}
