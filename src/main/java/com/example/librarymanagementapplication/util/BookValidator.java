/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 13-May-21
 *   Time: 10:18 PM
 *   File: BookValidator.java
 */

package com.example.librarymanagementapplication.util;

import com.example.librarymanagementapplication.model.Book;

public class BookValidator {
    public boolean isValid(Book book) {
        if (book.getTitle() == "" || book.getTitle() == null) {
            return false;
        }
        return true;
    }
}

