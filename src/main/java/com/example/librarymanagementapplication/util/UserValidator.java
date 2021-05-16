/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 13-May-21
 *   Time: 10:19 PM
 *   File: UserValidtor.java
 */

package com.example.librarymanagementapplication.util;

import com.example.librarymanagementapplication.model.User;

public class UserValidator {
    public static boolean isValidUser(User user) {
        if (user.getEmail() == null || user.getEmail() == "") {
            return false;
        }
        return true;
    }
}

