package com.group.libraryapp.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestLoanBook {
   private String userName;
   private String bookName;
   private boolean isReturn;
}
