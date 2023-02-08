package com.example.book.helper;

import com.example.book.entity.Author;

public class AuthorChild extends Author {
    double avgPrice = 0;

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }
}
