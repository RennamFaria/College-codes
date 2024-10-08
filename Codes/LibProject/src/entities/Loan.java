package entities;

import java.util.Date;

public class Loan {
    private String userId;
    private String bookId;
    private Date loanDate;
    private Date returnDate;

    public Loan(String userId, String bookId, Date loanDate, Date returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
