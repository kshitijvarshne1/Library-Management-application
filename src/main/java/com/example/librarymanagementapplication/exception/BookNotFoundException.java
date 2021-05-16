/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 13-May-21
 *   Time: 10:20 PM
 *   File: BookNotFoundException.java
 */

package com.example.librarymanagementapplication.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book id not found : " + id);
    }
}

