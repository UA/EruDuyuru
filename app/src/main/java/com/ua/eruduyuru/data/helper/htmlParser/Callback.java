package com.ua.eruduyuru.data.helper.htmlParser;

import com.ua.eruduyuru.utils.ErrorCodes;

public interface Callback<T> {
    void done(T result, ErrorCodes errorCodes);
}

